package com.dking.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 启动服务端的RMI请求服务
 *
 * Created by xinfei on 2018/6/6.
 */
public class StartServer {


    public static void main(String[] args) throws RemoteException, MalformedURLException {

        //(1)发布一个远程对象，在构造函数中，已经实现了，远程对象的发布
        IHelloService helloService = new HelloServiceImpl();

        //(2)
        LocateRegistry.createRegistry(1099);

        //(3) 将远程对象注册到 注册中心上
        Naming.rebind("rmi://127.0.0.1/Hello", helloService);

        System.out.println("SERVER: 服务启动成功");
    }





}
