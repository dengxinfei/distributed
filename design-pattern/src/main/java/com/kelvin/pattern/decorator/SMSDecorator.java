package com.kelvin.pattern.decorator;

/**
 * 装饰器模式：装饰器
 *
 * @ClassName SMSDecorator
 * @Author xinfei
 * @Date 2019/5/16
 * @Created add by xinfei/Kelvin 2019/5/16
 **/
public class SMSDecorator implements IMessage{

    //被装饰角色的实例。同样也可以传入装饰者角色。把装饰者也看作一个被装饰者
    private IMessage message;

    public SMSDecorator(IMessage message){
        this.message = message;
    }

    //装饰器类，所有装饰角色的父类。直接将被装饰的角色对象传入，执行被装饰对象的方法
    //定义了一个装饰器类的规范。其实每个具体装饰者都可以这样实现一遍。只是对所有的实现者定义了一个规范和抽象。
    public void invoke() {
        message.invoke();
    }
}
