package com.dking.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 模拟客户端远程调用服务端接口
 *
 * Created by xinfei on 2018/6/6.
 */
public class StartClient {

    /**
     * 客户端开始远程调用服务端接口
     *
     * @param args
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //(1)从注册机上获取服务的Stub
        IHelloService helloService = (IHelloService)Naming.lookup("rmi://127.0.0.1/Hello");

        //(2) 请求远程服务，stub
        String result = helloService.sayHello("DKing");
        System.out.println(result);
    }
}
