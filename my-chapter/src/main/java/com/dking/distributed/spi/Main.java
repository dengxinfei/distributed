package com.dking.distributed.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName Main
 * @Author xinfei
 * @Date 2018/8/17 11:41
 **/
public class Main {


    public static void main(String[] args) {
        ServiceLoader<ISpiService> serviceLoader = ServiceLoader.load(ISpiService.class);

        Iterator<ISpiService> services = serviceLoader.iterator();

        while(services.hasNext()){
            ISpiService service = services.next();
            if(service instanceof ASpiServiceImpl){
                System.out.println("A函数");
            }


            System.out.println(service.sendMessage("发送消息"));
        }


    }
}
