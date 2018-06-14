package com.dking.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xinfei on 2018/6/6.
 */
public interface IHelloService extends Remote{

    /**
     * 接收客户单请求的信息处理
     *
     * @param message
     * @return
     */
    String sayHello(String message) throws RemoteException;

}
