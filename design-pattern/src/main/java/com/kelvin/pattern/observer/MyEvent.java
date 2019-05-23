package com.kelvin.pattern.observer;

import java.lang.reflect.Method;

/**
 * 定义监听事件
 *
 * @ClassName MyEvent
 * @Author xinfei
 * @Date 2019/5/22
 * @Created add by xinfei/Kelvin 2019/5/22
 **/
public class MyEvent {

    private String eventName;

    private Object source; //事件源头

    private Object target; //通知目标监听者

    private Method callback;

    private String trigger; //触发源，也就是过滤的类型，相同内容过滤，此数过滤，黑名单过滤

    private long time;

    public MyEvent(Object target, Method callback){
        this.target = target;
        this.callback = callback;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "eventName='" + eventName + '\'' +
                ", source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
