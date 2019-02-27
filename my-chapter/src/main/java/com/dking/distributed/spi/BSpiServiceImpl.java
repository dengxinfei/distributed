package com.dking.distributed.spi;

/**
 * @ClassName BSpiServiceImpl
 * @Author xinfei
 * @Date 2018/8/17 11:36
 **/
public class BSpiServiceImpl implements ISpiService {


    @Override
    public String sendMessage(String message) {
        message = "BSpiServiceImpl->" + message;
        return message;
    }
}
