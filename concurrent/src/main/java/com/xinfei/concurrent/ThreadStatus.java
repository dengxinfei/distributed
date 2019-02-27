package com.xinfei.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态演示代码
 *
 * @ClassName ThreadStatus
 * @Author xinfei
 * @Date 2018/8/23 17:19
 **/
public class ThreadStatus {


    public static void main(String[] args) {
        //演示TIME-WAITTING状态的线程
//        Thread thread = new Thread(()->{
//            while (true){
//                try {
//                    TimeUnit.SECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"time-waiting");
//        thread.start();UFO需求评审


        //演示WAITTING状态
        new Thread(() -> {
            while (true){
                synchronized (ThreadStatus.class){
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "waitting").start();

    }


}
