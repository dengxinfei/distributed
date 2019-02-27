package com.ken.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MSServiceApplication
 * @Author xinfei
 * @Date 2018/7/20 18:02
 **/
@SpringBootApplication
public class MSServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MSServiceApplication.class);
        //设置随机生成端口
        Map<String, Object> properties = new HashMap<String, Object>();
//        properties.put("server.port", 0);
//        springApplication.setDefaultProperties(properties);

        //设置应用为非WEB应用
//        springApplication.setWebEnvironment(false);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);

        ConfigurableApplicationContext context = springApplication.run(args);

        System.err.println(context.getBean(MSServiceApplication.class));
        System.err.println(context.getClass().getName());



    }




}
