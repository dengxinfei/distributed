package com.dking.distributed.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务端SOCKET请求
 *
 * Created by xinfei on 2018/6/1.
 */
public class ServerSocketDemo {


    /**
     * 模拟访问服务端SOCKET流的处理过程
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = null;
        BufferedReader br = null;
        PrintWriter writer = null;
        try {
            //(1)启动一个Server, 监听一个端口。 相当于进程的监听
            server = new ServerSocket(8090);
            System.out.println("SERVER--我启动了 ");

            Socket socket = null;
            while (1 == 1) {
                //(2)开始监听，获取客户端的连接。 如果有客户端连接，则新建一个socket对象
                socket = server.accept();
                System.out.println("SERVER--有请求过来了.....");

                //(3)使用InputStream获取客户端传过来的信息
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //(4) 打印客户端的请求数据
                System.out.println("SERVER--我收到了客户端的消息： " + br.readLine());

                //-----------------TCP连接是双工的，向客户端返回信息--------------------
                //(1)获取socket的输出流
                writer = new PrintWriter(socket.getOutputStream());
                //(2)给客户端返回相应消息
                String returnMsg = "ACK Hello Dking";
                System.out.println("SERVER--我要跟客户端回复消息： " + returnMsg);
                writer.println(returnMsg);
                writer.flush();
                System.out.println("------------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("SERVER--我要关闭流了： ");
            if (null != server){
                server.close();
            }
            br.close();
            writer.close();
        }


    }








}
