package com.dking.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态创建代理对象
 *
 * Created by xinfei on 2018/6/11.
 */
public class MyProxy {

    /**
     * 创建一个代理对象
     *
     * @param clazz
     * @param handler
     * @param <T>
     * @return
     */
    public <T> T buildProxy(final Class<T> clazz, InvocationHandler handler){
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
    }




}
