package com.distributed.zk.natives;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 监听事件模拟
 *
 * Created by xinfei on 2018/6/11.
 */
public class WatcherDemo {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        MyWatcher myWatcher = new MyWatcher();
        final ZooKeeper zooKeeper;
        try {
            //(1)连接ZK集群。
            zooKeeper = new ZooKeeper("127.0.0.1:1111,127.0.0.1:2222,127.0.0.1:3333", 3000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取监听事件. TYPE=" + watchedEvent.getType() + "...Path=" + watchedEvent.getPath() );
                    if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
                        countDownLatch.countDown();
                    }
                    //zooKeeper.exists(watchedEvent.getPath(), true);


                }
            });

            //(2) 线程等待
            countDownLatch.await();
            System.out.println("ZK连接成功。 状态=" + zooKeeper.getState());

            //(3)创建节点
            //String v = zooKeeper.create("/xinfei", "2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //System.out.println(v);

            //(3)监听节点的数据
            //zooKeeper.exists("/xinfei", true);


            //(4)获取数据
            Stat stat = new Stat();
            zooKeeper.getData("/xinfei", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("getData 监听事件" + watchedEvent.toString());
                }
            }, stat);
//
//            //(5) 更新数据
//            zooKeeper.setData("/xinfei", "999".getBytes(), stat.getVersion());
//            System.out.println("更新数据成功");
            System.in.read();
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
