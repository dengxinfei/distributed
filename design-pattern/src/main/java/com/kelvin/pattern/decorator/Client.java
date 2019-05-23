package com.kelvin.pattern.decorator;

/**
 * 装饰者模式-客户端调用测试
 *
 * @ClassName Client
 * @Author xinfei
 * @Date 2019/5/16
 * @Created add by xinfei/Kelvin 2019/5/16
 **/
public class Client {

    public static void main(String[] args) {
        //(1)被装饰者对象, 没有其他装饰，只能有自己发送的功能
        IMessage send = new SMSSend();
        send.invoke();
        System.out.println("--------------------------------");

        //(2)装饰过滤重复内容的功能，就有过滤重复内容和发送的功能
        IMessage send1 = new FilterSame(send);
        send1.invoke();
        System.out.println("--------------------------------");

        //(3)在2的基础上，在装饰此数限制过滤
        IMessage send2 = new TimeLimit(send1);
        send2.invoke();
    }
}
