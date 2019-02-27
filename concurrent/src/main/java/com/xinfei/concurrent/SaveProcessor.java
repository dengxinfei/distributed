package com.xinfei.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName SaveProcessor
 * @Author xinfei
 * @Date 2018/8/15 17:21
 **/
public class SaveProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue();

    @Override
    public void run(){
        while (true){
            try {
                Request request = linkedBlockingQueue.take();
                System.out.println("save data:"+request);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void processRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
