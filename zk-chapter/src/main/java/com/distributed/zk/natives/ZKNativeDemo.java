package com.distributed.zk.natives;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 原生的方式操作ZK。
 * 1、连接ZK集群
 * 2、创建监听
 * 3、
 *
 * Created by xinfei on 2018/6/11.
 */
public class ZKNativeDemo {

    public final static CountDownLatch countDownLatch = new CountDownLatch(1);


    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        MyWatcher myWatcher = new MyWatcher();
        try {
            //(1)连接ZK集群。
            zooKeeper = new ZooKeeper("127.0.0.1:1111,127.0.0.1:2222,127.0.0.1:3333", 3000, myWatcher);

            //(2) 线程等待
            countDownLatch.await();
            System.out.println("ZK连接成功。 状态=" + zooKeeper.getState());

            //(3)创建节点
            String v = zooKeeper.create("/xinfei", "2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //System.out.println(v);

            //(4)获取节点数据
            Stat stat = new Stat();
            byte[] bytes = zooKeeper.getData("/xinfei", false, stat);
            System.out.println("获取节点数据： bytes=" + new String(bytes));

            //(5)修改当前节点的值
            stat = zooKeeper.setData("/xinfei", "555".getBytes(), stat.getVersion());

            //(6)删除节点的值
            zooKeeper.delete("/xinfei", stat.getVersion());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } finally {
            try {
                zooKeeper.close();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
