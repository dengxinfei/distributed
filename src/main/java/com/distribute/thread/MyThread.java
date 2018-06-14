package com.distribute.thread;

/**
 * 自定义线程
 *
 * Created by xinfei on 2018/6/11.
 */
public class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("当前线程是：" + Thread.currentThread().getName());
    }



}
