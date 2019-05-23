package com.kelvin.pattern.observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象被观察者角色：事件监听装置。负责监听被观察者(Subject)的行为。
 * 举例：短信发送
 * 短信发送过程中需要经过很多的过滤。相同内容过滤，此数过滤，黑名单过滤等。
 * 经过每一层过滤之后监听者根据过滤的结果进行日志汇总。
 *
 * @ClassName Listener
 * @Author xinfei
 * @Date 2019/5/22
 * @Created add by xinfei/Kelvin 2019/5/22
 **/
public class Listener {

    //存储监听的事件信息
    private Map<FilterEnum, List<MyEvent>> eventMap = new HashMap<FilterEnum, List<MyEvent>>();

    /**
     * 添加事件通知，添加监听。
     * 被观察者发生某件事情的时候，会主动的通知到监听器，监听器查询出所有正在监听的监听者，通知监听者。
     * 根据上述，需要监听者提供那些信息呢。
     * 1、监听的事件类型，也就是监听哪些感兴趣的事件。
     * 2、被监听者发生事件后，事件怎么通知到监听者。也就是回调的函数。此时就需要反射来处理了
     * 3、如果要通知到监听者，那么就需要监听者的对象
     */
    public void addListener(FilterEnum filterEnum, Object observer, Method method){
        //定义某个观察类型
        List<MyEvent> myEvents = eventMap.get(filterEnum);
        if(null == myEvents || myEvents.isEmpty()){
            myEvents = new ArrayList<MyEvent>();
        }

        //将新的时间加入到观察者列表中
        myEvents.add(new MyEvent(observer, method));
        eventMap.put(filterEnum, myEvents);
    }

    //被观察者SUBJECT发生事件，通知事件中心。类似生产者生产消息
    public void addTrigger(FilterEnum filterEnum){
        //如果当前事件没有观察者，则不需要通知。也就是观察者加入观察要在事件发生之前。
        if(!eventMap.containsKey(filterEnum)){
            return;
        }

        try {
            //获取监听者
            List<MyEvent> myEventList = eventMap.get(filterEnum);
            if(null == myEventList || myEventList.isEmpty()){
                return;
            }

            //循环通知观察者
            for(MyEvent myEvent: myEventList){
                myEvent.setTrigger(filterEnum.toString()); //设置触发事件类型
                myEvent.setSource(this); //设置发送事件的源头
                myEvent.setTime(System.currentTimeMillis());//设置事件的发生时间

                //回调通知监听者
                Method callback =  myEvent.getCallback();
                callback.invoke(myEvent.getTarget(), myEvent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
