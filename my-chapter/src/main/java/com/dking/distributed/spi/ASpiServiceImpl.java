package com.dking.distributed.spi;

/**
 * @ClassName ASpiServiceImpl
 * @Author xinfei
 * @Date 2018/8/17 11:36
 **/
public class ASpiServiceImpl implements ISpiService {


    @Override
    public String sendMessage(String message) {
        message = "ASpiServiceImpl->" + message;
        return message;
    }
}
