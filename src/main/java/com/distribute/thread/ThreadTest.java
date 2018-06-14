package com.distribute.thread;

/**
 * Created by xinfei on 2018/6/11.
 */
public class ThreadTest {


    public static void main(String[] args) {
        Thread myThread1 = new MyThread("我是线程1");
        Thread myThread2 = new MyThread("我是线程2");
        myThread1.start();
        myThread2.start();
    }
}
