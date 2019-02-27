package com.ken.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @ClassName ApplicationEventMulticasterDemo
 * @Author xinfei
 * @Date 2018/7/21 16:39
 **/
public class ApplicationEventMulticasterDemo {


    public static void main(String[] args) {
        ApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();

//        BeanFactory


        multicaster.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            public void onApplicationEvent(ApplicationEvent event) {
                if (event instanceof PayloadApplicationEvent) {
                    System.out.println("接受到 PayloadApplicationEvent :"
                            + PayloadApplicationEvent.class.cast(event).getPayload());
                }else {
                    System.out.println("接收到事件：" + event);
                }

            }
        });

        multicaster.multicastEvent(new MyEvent("Hello Ken"));
        multicaster.multicastEvent(new PayloadApplicationEvent<Object>("2", "Hello"));
    }

    private static class MyEvent extends ApplicationEvent {

        public MyEvent(Object source) {
            super(source);
        }
    }
}
