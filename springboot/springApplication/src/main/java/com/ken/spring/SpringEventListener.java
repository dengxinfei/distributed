package com.ken.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @ClassName SpringEventListener
 * @Author xinfei
 * @Date 2018/7/21 16:14
 **/
public class SpringEventListener {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
//        context.registerBeanDefinition();
        context.addApplicationListener(new ClosedListener());

        context.addApplicationListener(new RefreshedListener());
        context.refresh();

        context.publishEvent(new MyEvent("Hello Ken"));



        context.close();
    }


    private static class RefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            System.err.println("上下文启动：" + contextRefreshedEvent);
        }
    }

    private static class ClosedListener implements ApplicationListener<ContextClosedEvent> {

        public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
            System.err.println("关闭上下文：" + contextClosedEvent);
        }
    }

    private static class MyEvent extends ApplicationEvent{

        public MyEvent(Object source) {
            super(source);
        }
    }









}





