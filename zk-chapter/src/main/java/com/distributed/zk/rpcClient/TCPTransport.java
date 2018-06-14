package com.distributed.zk.rpcClient;

import com.distributed.zk.RpcRequest;
import com.distributed.zk.rpcServer.ZKConfig;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by xinfei on 2018/6/13.
 */
public class TCPTransport {

    private ServerDiscovery serverDiscovery;

    /**
     * 通过SOCKET 发送TCP请求
     * @param request
     * @return
     */
    public<T> T send(RpcRequest request){
        //(1)获取服务注册的信息
        serverDiscovery = new ServerDiscovery();
        String path = serverDiscovery.getRegister(ZKConfig.ZK_REGISTER_PATH);

        //(2)获取端口以及IP地址信息
        String[] array = path.split(":");
        String ip = array[0];
        int port = Integer.parseInt(array[1]);


        Socket socket = null;
        try {
            //(3)建立SOCKET连接
            socket = new Socket(ip, port);

            //(4)发送消息到服务端
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            //(4)获取服务端的消息返回
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            T obj = (T)objectInputStream.readObject();
            objectOutputStream.close();
            objectInputStream.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

}
