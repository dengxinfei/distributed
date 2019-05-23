package com.kelvin.pattern.observer;

/**
 * 具体观察者(日志观察者)：监听者，监听事件，事件发生之后，通知监听者
 *
 * @ClassName Observer
 * @Author xinfei
 * @Date 2019/5/22
 * @Created add by xinfei/Kelvin 2019/5/22
 **/
public class LoggerObserver implements IObserver{

    /**
     * 监听事件的回调。当发生需要监控的事件的时候，监听中心发送消息到监听者。
     *
     * @param myEvent 事件信息
     */
    public void doLogger(MyEvent myEvent){
        //获取当前监听的事件的类型
        String trigger = myEvent.getTrigger();
        if("SAME_CONTENT".equals(trigger)){
            System.out.println("日志观察者：记录相同内容过滤日志");
        }else if("TIME_FILTER".equals(trigger)){
            System.out.println("日志观察者：记录此数过滤日志");
        }else if("BLACK_LIST".equals(trigger)){
            System.out.println("日志观察者：记录黑名单过滤日志");
        }
    }
}
