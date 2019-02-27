package com.ken.microservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName SpringBootEvent
 * @Author xinfei
 * @Date 2018/7/20 18:26
 **/
@EnableAutoConfiguration
public class SpringBootEvent {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEvent.class).listeners(new ApplicationListener<ApplicationEvent>() {
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                System.err.println("收到监听事件：" + applicationEvent.getClass().getSimpleName());
            }
        }).run(args).close();
    }



}
