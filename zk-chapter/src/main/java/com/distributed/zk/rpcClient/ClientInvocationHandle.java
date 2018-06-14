package com.distributed.zk.rpcClient;

import com.distributed.zk.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * 最终处理消息发送
 *
 * Created by xinfei on 2018/6/13.
 */
public class ClientInvocationHandle implements InvocationHandler {


    /**
     * 通过TCP连接， 发送请求到服务端
     *
     * @param proxy 代理的真实的类
     * @param method 代理的真实的方法
     * @param args 请求参数
     * @return TCP请求返回值
     *
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //组装请求的对象
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);

        TCPTransport tcpTransport = new TCPTransport();
        return tcpTransport.send(rpcRequest);
    }
}
