package com.kelvin.pattern.decorator;

/**
 * 装饰者模式-具体的装饰者
 *
 * @ClassName TimeLimit
 * @Author xinfei
 * @Date 2019/5/16
 * @Created add by xinfei/Kelvin 2019/5/16
 **/
public class TimeLimit extends SMSDecorator{

    public TimeLimit(IMessage message) {
        super(message);
    }

    //发送此数过滤
    @Override
    public void invoke() {
        System.out.println("我要过滤相同的内容");
        super.invoke();
    }
}
