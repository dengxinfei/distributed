package com.dking.distributed.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 线程处理接收消息
 *
 * Created by xinfei on 2018/6/1.
 */
public class BIOThread implements Runnable {

    private Socket serverSocket;

    private String name;

    //创建构造函数处理，定义SOCKET连接
    public BIOThread(Socket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void run() {
        BufferedReader br = null;
        PrintWriter writer = null;
        System.out.println("【" + Thread.currentThread().getName() + "】SERVER: 开始处理消息了");
        try {
            //(1)使用InputStream获取客户端传过来的信息
            br = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

            //(2) 打印客户端的请求数据
            System.out.println("【" + Thread.currentThread().getName() + "】SERVER--我收到了客户端的消息： " + br.readLine());

            //-----------------TCP连接是双工的，向客户端返回信息--------------------
            //(3)获取socket的输出流
            writer = new PrintWriter(serverSocket.getOutputStream());

            //(4)给客户端返回相应消息
            String returnMsg = "ACK Hello Dking";
            System.out.println("【" + Thread.currentThread().getName() + "】SERVER--我要跟客户端回复消息： " + returnMsg);

            //(5)发送响应消息
            writer.println(returnMsg);
            writer.flush();
            System.out.println("------------------------------------------------------------------");
        }catch (Exception e){
            try {
                br.close();
                writer.close();
            } catch (IOException e1) {
            }
        }
    }
}
