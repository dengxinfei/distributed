package com.distributed.zk.rpcClient;

import com.distributed.zk.IHandle;

import java.lang.reflect.Proxy;

/**
 * 模拟发送RPC请求
 *
 * Created by xinfei on 2018/6/13.
 */
public class RPClientDemo {

    public static void main(String[] args) {
        ClientInvocationHandle clientInvocationHandle = new ClientInvocationHandle();

        //(1)创建代理对象
//        IHandle handle = (IHandle)Proxy.newProxyInstance(IHandle.class.getClassLoader(), new Class[]{IHandle.class}, clientInvocationHandle);
        IHandle handle = (IHandle)Proxy.newProxyInstance(IHandle.class.getClassLoader(), IHandle.class.getClasses(), clientInvocationHandle);
        //(2)开始调用
        String result = handle.sayHello("邓新飞");
        System.out.println("通过RPC调用，获取服务端的返回====" + result);


    }

}
