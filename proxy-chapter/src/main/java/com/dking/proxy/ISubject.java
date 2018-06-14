package com.dking.proxy;

/**
 * 被动态代理的类
 *
 * Created by xinfei on 2018/6/11.
 */
public interface ISubject {
    /**
     * 动态代理类的方式实现
     *
     * @param str
     * @return
     */
     String sayHello(String str);

}
