package com.xinfei.concurrent;

/**
 * @ClassName Request
 * @Author xinfei
 * @Date 2018/8/15 16:27
 **/
public class Request {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
