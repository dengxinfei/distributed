package com.kelvin.pattern.observer;

/**
 * 具体观察者(统计观察者)：当发生需要监控的事件的时候，监听中心发送消息到监听者。
 *
 * @ClassName StatObserver
 * @Author xinfei
 * @Date 2019/5/22
 * @Created add by xinfei/Kelvin 2019/5/22
 **/
public class StatObserver implements IObserver {

    /**
     * 统计调用的观察者，统计被观察者方法的调用
     *
     * @param myEvent
     */
    public void doLogger(MyEvent myEvent) {
        //获取当前监听的事件的类型
        String trigger = myEvent.getTrigger();
        if("SAME_CONTENT".equals(trigger)){
            System.out.println("统计观察者：记录相同内容过滤调用次数\n");
        }else if("TIME_FILTER".equals(trigger)){
            System.out.println("统计观察者：记录此数调用次数\n");
        }else if("BLACK_LIST".equals(trigger)){
            System.out.println("统计观察者：记录黑名单过滤调用次数\n");
        }
    }
}
