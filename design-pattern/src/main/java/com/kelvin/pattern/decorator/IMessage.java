package com.kelvin.pattern.decorator;

/**
 * 定义一个被装饰角色的定义。定义一个规范，规范被装饰角色的行为。
 * 所有的装饰角色也最终实现这个类。
 *
 * @ClassName IMessage
 * @Author xinfei
 * @Date 2019/5/16 20:08
 * @Created add by xinfei/Kelvin 2019/5/16
 **/
public interface IMessage {

    //我们就以发送短信为例, 调用短信发送
    public void invoke();

}