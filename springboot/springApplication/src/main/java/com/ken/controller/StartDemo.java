package com.ken.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName StartDemo
 * @Author xinfei
 * @Date 2018/7/24 17:23
 **/
@SpringBootApplication
public class StartDemo {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StartDemo.class);

        application.run(args);
    }
}
