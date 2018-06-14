package com.dking.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xinfei on 2018/6/6.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService{


    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    /**
     * 提供给客户端使用的服务接口
     *
     * @param message 客户端传过来的请求信息
     * @return 返回请求信息
     */
    public String sayHello(String message) throws RemoteException{
        return "SERVER: 我接收到了客户端的消息=" + message;
    }
}
