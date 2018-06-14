package com.distributed.zk.natives;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xinfei on 2018/6/11.
 */
public class MyWatcher implements Watcher {

//    private CountDownLatch countDownLatch;
//
//    public MyWatcher(CountDownLatch countDownLatch) {
//        this.countDownLatch = countDownLatch;
//    }

    /**
     * 重写watcher方法
     *
     * @param watchedEvent watcher事件
     */
    public void process(WatchedEvent watchedEvent) {
        System.out.println("MyWatcher: 进入watch回调，状态=" + watchedEvent.getState());
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            ZKNativeDemo.countDownLatch.countDown();
        }


    }
}
