package com.dking.distributed.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务端SOCKET请求
 *
 * Created by xinfei on 2018/6/1.
 */
public class ThreadServerSocketDemo {


    /**
     * 模拟访问服务端SOCKET流的处理过程
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            //(1)启动一个Server, 监听一个端口。 相当于进程的监听
            serverSocket = new ServerSocket(8090);
            System.out.println("SERVER--我启动了 ");

            //(2)开始监听，获取客户端的连接。 如果有客户端连接，则新建一个socket对象
            int i = 0;

            while(i < 100) {
                socket = serverSocket.accept();
                System.out.println("SERVER--建立连接....." + i);

                //(3)启动一个线程进行处理消息
                BIOThread thread = new BIOThread(socket);
                new Thread(thread, "线程-" + i).start();
                System.out.println("SERVER--开始下一个监听");
                i++;
            }
        } catch (Exception e) {
            System.out.println("出异常拉");
            e.printStackTrace();
        }finally {
            System.out.println("SERVER--我要关闭流了： ");
            if (null != serverSocket){
                serverSocket.close();
            }
        }
    }

}
