package com.distributed.zk.lock;

import jdk.nashorn.internal.runtime.regexp.joni.constants.NodeStatus;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by xinfei on 2018/6/12.
 */
public class ZKLock implements Lock, Watcher{

    private ZooKeeper zooKeeper;

    CountDownLatch countDownLatch; //定义阻塞线程

    CountDownLatch countDownLatch2 = new CountDownLatch(1); //判断ZK连接成功再次执行

    private String ROOT_NODE = "/locks"; //定义根节点

    private String CURRENT_LOCK; //定义当前锁

    private String WAIT_LOCK; //定义等待的锁

    public ZKLock(){
        try {
            zooKeeper = new ZooKeeper("127.0.0.1:1111", 4000, this);
            countDownLatch2.await(); //等待ZK连接

            Stat stat = zooKeeper.exists(ROOT_NODE, false);
            if(null == stat){
                zooKeeper.create(ROOT_NODE, "3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void lock() {
        //当前线程获取锁资源
        if(this.tryLock()){
            System.out.println("线程：" + Thread.currentThread().getName() + "--获取锁成功。");
            return;
        }

        //没有获取到锁，进入等待状态
        waitForLock();
    }

    //进入等待状态，监听等待的节点事件
    private boolean waitForLock(){
        try {
            Stat stat = zooKeeper.exists(WAIT_LOCK, true);
            if(null != stat){
                System.out.println("线程：" + Thread.currentThread().getName() + "--等待线程释放...." + WAIT_LOCK);
            }
            countDownLatch = new CountDownLatch(1);
            countDownLatch.await();

            System.out.println("线程：" + Thread.currentThread().getName() + "获取锁成功");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void lockInterruptibly() throws InterruptedException {
        System.out.println("进入lockInterruptibly().............");
    }

    public boolean tryLock() {
        try {
            //(1) 创建一个临时有序节点
            CURRENT_LOCK = zooKeeper.create(ROOT_NODE + "/", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("线程" + Thread.currentThread().getName()+"尝试竞争锁：" + CURRENT_LOCK);

            //(2) 获取所有的子节点
            List<String> childrens = zooKeeper.getChildren(ROOT_NODE, false);

            //(3) 所有的子节点排序，
            TreeSet<String> sortedSet = new TreeSet();
            for(String child: childrens){
                sortedSet.add(ROOT_NODE + "/" + child);
            }

            //(4) 获取最小的节点, 如果当前节点是最小的节点， 直接获取锁
            String firstNode = sortedSet.first();
            if(CURRENT_LOCK.equals(firstNode)){
                return true;
            }

            //(5) 走到这一步，说明当前节点没有获取到锁，获取需要监听的上一个节点
            SortedSet<String> lessSort = sortedSet.headSet(CURRENT_LOCK);
            WAIT_LOCK = lessSort.last();

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        System.out.println("tryLock(time, unit)");

        return false;
    }

    public void unlock() {
        System.out.println("unlock()");

    }

    public Condition newCondition() {
        System.out.println("newCondition()");
        return null;
    }

    /**
     * 系统处理事件回调函数
     *
     * @param watchedEvent
     */
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            countDownLatch2.countDown();
        }

        if(null == countDownLatch){
            return;
        }
        countDownLatch.countDown();
    }
}
