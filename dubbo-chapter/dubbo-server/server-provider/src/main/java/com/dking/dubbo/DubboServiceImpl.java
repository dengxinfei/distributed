package com.dking.dubbo;

/**
 * 提供的dubbo服务的具体实现方法
 *
 * Created by xinfei on 2018/6/19.
 */
public class DubboServiceImpl implements IDubboService{


    public String sayHello(String msg) {
        return "服务端收到请求, 请求内容是：" + msg;
    }
}
