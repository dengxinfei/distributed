package com.xinfei.concurrent;

/**
 * @ClassName Demo
 * @Author xinfei
 * @Date 2018/8/15 18:05
 **/
public class Demo {

    PrintProcessor printProcessor;

    public Demo(){
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();

        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }


    public static void main(String[] args) {
        Request request = new Request();
        request.setName("xinfei");
        new Demo().doTest(request);
    }


    public void doTest(Request request){
        printProcessor.processRequest(request);
    }


}
