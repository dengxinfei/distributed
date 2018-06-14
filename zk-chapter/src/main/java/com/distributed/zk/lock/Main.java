package com.distributed.zk.lock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xinfei on 2018/6/12.
 */
public class Main {
    private CountDownLatch countDownLatch = new CountDownLatch(10);


    public static void main(String[] args) {
        Main main = new Main();
        main.deal();
    }


    public void deal(){
        //创建10个线程，获取锁资源

        for(int i = 0; i < 10; i++){
            new MyThread("线程" + i).start();
            countDownLatch.countDown();
        }

    }



    class MyThread extends Thread{
        @Override
        public void run(){
            //等待线程全部创建完成，再执行
            countDownLatch.countDown();
            ZKLock myLock = new ZKLock();
            myLock.lock();
        }

        public MyThread(String name){
            super(name);
        }
    };


}
