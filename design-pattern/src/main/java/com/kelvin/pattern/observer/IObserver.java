package com.kelvin.pattern.observer;

/**
 * 抽象的观察者角色。定义自己收到通知的回调的方法
 *
 * @ClassName IObserver
 * @Author xinfei
 * @Date 2019/5/22 18:11
 * @Created add by xinfei/Kelvin 2019/5/22
 **/
public interface IObserver {

    /**
     * 定义收到通知的回调方法
     *
     * @param myEvent
     */
    void doLogger(MyEvent myEvent);
}
