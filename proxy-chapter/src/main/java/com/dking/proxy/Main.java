package com.dking.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试代理类的主方法
 *
 * Created by xinfei on 2018/6/11.
 */
public class Main {

    public static void main(String[] args) {
        ISubject relSubject = new RelSubject();

        //创建代理对象，指定我们需要代理的哪个对象。
        InvocationHandler handler = new MyInvocationHandle(relSubject);

        //生成代理对象。
        //三个参数
        //参数1：被代理的对象的classLoader. 被代理的对象使用哪个类装载器
        //参数2：newProxyInstance()方法返回的代理对象要实现哪些接口
        //参数3：指名产生代理对象要做的事情. 动态代理对象调用方法的时候，关联到哪一个InvocationHandler
        ISubject subject = (ISubject)Proxy.newProxyInstance(relSubject.getClass().getClassLoader(), relSubject.getClass().getInterfaces(), handler);

//        ISubject subject = (ISubject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), relSubject.getClass().getInterfaces(), handler);
        String result = subject.sayHello("我来了");
        System.out.println(result);

    }
}
