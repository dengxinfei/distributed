package com.dking.distributed.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 模拟客户端的TCP请求
 *
 * Created by xinfei on 2018/6/1.
 */
public class Client1SocketDemo {


    public static void main(String[] args) {
        Socket clientSocket = null;
        BufferedReader br = null;
        PrintWriter writer = null;

        try {
            //(1)创建客户端的SOCKET连接
            clientSocket = new Socket("127.0.0.1", 8090);

            //(2)从控制台输入信息
            br = new BufferedReader(new InputStreamReader(System.in));
            String readLine = br.readLine();
            System.out.println("Client1: 我要向服务端发送消息：" + readLine);

            //(3)获取SOCKET的输出流，将消息发送到服务端
            writer = new PrintWriter(clientSocket.getOutputStream());
            writer.println("Client1--" + readLine);
            writer.flush();

            //----------------------以下是接收服务端的消息-------------------
            //(1)获取SOCKET的输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String result = bufferedReader.readLine();
            System.out.println("Client1: 我接收到服务端的返回消息：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != writer){
                writer.close();
            }

            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null != clientSocket){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }





        }


    }



}
