package com.dking.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 客户端通过DUBBO的方式调用服务端的信息
 *
 * Created by xinfei on 2018/6/19.
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/dubbo-client.xml");
        context.start();
        IDubboService dubboService = (IDubboService)context.getBean("dubboService");
//        String result = dubboService.sayHello("第一个DUBBO实例");
//        System.out.println(result);

        System.in.read();

    }

}
