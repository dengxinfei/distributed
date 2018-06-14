package com.distributed.zk.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;

/**
 * 使用curator的方式获取竞争锁
 *
 * Created by xinfei on 2018/6/12.
 */
public class CuratorLock {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        CuratorLock main = new CuratorLock();
        main.deal();
    }

    public void deal(){
        //创建10个线程，获取锁资源

        for(int i = 0; i < 10; i++){
            new MyThread2("线程" + i).start();
        }
    }


    class MyThread2 extends Thread{
        @Override
        public void run(){
            CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                    connectString("127.0.0.1:1111").retryPolicy(new ExponentialBackoffRetry(1000, 1)).sessionTimeoutMs(2000).build();
            curatorFramework.start();
            InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/locks");
            try {
                interProcessMutex.acquire();
                System.out.println("线程" + Thread.currentThread().getName() + "----获取锁");
                interProcessMutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public MyThread2(String name){
            super(name);
        }
    };
}
