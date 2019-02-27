package com.xinfei.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName PrintProcessor
 * @Author xinfei
 * @Date 2018/8/15 17:04
 **/
public class PrintProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingQueue<Request> requestsQueue = new LinkedBlockingQueue<Request>();

    //SaveProcessor
    private final IRequestProcessor nextProcessor;


    public PrintProcessor(IRequestProcessor processor){
        this.nextProcessor = processor;
    }


    public void processRequest(Request request) {
        requestsQueue.add(request);
    }


    @Override
    public void run(){
        while (true){
            try {
                Request request = requestsQueue.take();
                System.out.println("print data:" + request.getName());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
