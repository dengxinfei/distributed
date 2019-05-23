package com.kelvin.pattern.observer;

import java.awt.*;

/**
 * 具体被观察者角色：被监听的主题。被监视者。
 * 当被监视者发生行为的时候，会将自己的行为发送给监听中心，判断是否有观察者监听当前事件。
 * 如果有监听者监听当前事件，触发调用监听者的回调函数。
 *
 * @ClassName Subject
 * @Author xinfei
 * @Date 2019/5/22
 * @Created add by xinfei/Kelvin 2019/5/22
 **/
public class Subject extends Listener {

    //对应监听的类型的函数-相同内容的过滤
    public void filterSameContent(){
        System.out.println("被观察者：开始过滤重复内容");
        //添加事件监听, 可以定义动态代理，方法执行之计添加动态监听。
        addTrigger(FilterEnum.SAME_CONTENT);
    }

    //此数的过滤
    public void filterTimes(){
        System.out.println("被观察者：开始过滤此数");
        //添加事件监听，可以定义动态代理，方法执行之计添加动态监听。
        addTrigger(FilterEnum.TIME_FILTER);
    }

    //开始过滤黑名单
    public void filterBlackList(){
        System.out.println("被观察者：开始进行黑名单的过滤");
        //添加事件监听，可以定义动态代理，方法执行之计添加动态监听。
        addTrigger(FilterEnum.BLACK_LIST);
    }

}
