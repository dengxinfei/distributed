package com.kelvin.pattern.decorator;

/**
 * 装饰器-具体被装饰的对象
 *
 * @ClassName SMSSend
 * @Author xinfei
 * @Date 2019/5/16
 * @Created add by xinfei/Kelvin 2019/5/16
 **/
public class SMSSend implements IMessage{

    public void invoke() {
        System.out.println("我要发送短信了");
    }
}
