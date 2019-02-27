package com.dking.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 启动DUBBO服务
 *
 * Created by xinfei on 2018/6/19.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //Spring的方式加载
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/dubbo-server.xml");
        context.start();
        System.out.println("DUBBO启动成功");
        System.in.read();

    }


}
