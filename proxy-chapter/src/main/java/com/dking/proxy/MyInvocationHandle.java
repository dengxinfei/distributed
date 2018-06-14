package com.dking.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实现动态代理
 *
 * Created by xinfei on 2018/6/11.
 */
public class MyInvocationHandle implements InvocationHandler{

    //动态代理类的对象
    private Object realObj;


    public MyInvocationHandle() {
    }

    //
    public MyInvocationHandle(Object realObj) {
        this.realObj = realObj;
    }


    /**
     * 重写动态代理的实现方法
     *
     * @param proxy 我们代理的那个真实的对象
     * @param method 调用的真实对象的那个方法
     * @param args 调用真实对象的方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(realObj, args);
        System.out.println("invoke: " + result);
//        Method[] methods = proxy.getClass().getDeclaredMethods();
//        Object obj = method.invoke(proxyObj, args);
        return result;
    }
}
