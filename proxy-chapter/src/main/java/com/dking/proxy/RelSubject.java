package com.dking.proxy;

/**
 * 动态代理类的实现
 *
 * Created by xinfei on 2018/6/11.
 */
public class RelSubject implements ISubject {


    public String sayHello(String str) {
        System.out.println("已经调用了动态代理对象......");
        return "Hello" + str;
    }


}
