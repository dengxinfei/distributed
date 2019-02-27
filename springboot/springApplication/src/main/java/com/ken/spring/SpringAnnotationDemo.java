package com.ken.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringAnnotationDemo
 * @Author xinfei
 * @Date 2018/7/21 13:32
 **/
@Configuration
public class SpringAnnotationDemo {



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();


        context.register(SpringAnnotationDemo.class);
        context.refresh();
        System.err.println(context.getBean(SpringAnnotationDemo.class));
    }

}
