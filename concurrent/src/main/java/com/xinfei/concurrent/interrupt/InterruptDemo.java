package com.xinfei.concurrent.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName InterruptDemo
 * @Author xinfei
 * @Date 2018/8/27 11:15
 **/
public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {

//        Thread thread1 = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()){
//                i++;
//            }
//            System.out.println("Num: " + i);
//        }, "interrupt");
//        thread1.start();
//        thread1.interrupt();

//
//        Thread thread2 = new Thread(new ThreadInter(), "thread2");
//        thread2.start();
//        TimeUnit.SECONDS.sleep(1);
//        thread2.interrupt();

        Thread thread3 = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"thread3");
        thread3.start();
        thread3.interrupt(); //设置中断标示=TRUE
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread3.isInterrupted());

    }


    static class ThreadInter extends Thread{

        @Override
        public void run(){
            while(true){
                boolean isInterrupt = Thread.currentThread().isInterrupted();
                if(isInterrupt){
                    System.out.println("before : " + i);
                    Thread.interrupted(); //线程进行复位，中断标示设置成FALSE
                    System.out.println("After: " + Thread.currentThread().isInterrupted());
                }
            }
        }
    }
}
