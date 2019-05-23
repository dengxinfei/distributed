package com.kelvin.pattern.observer;

import java.lang.reflect.Method;

/**
 * 测试监听者模式
 *
 * @ClassName Main
 * @Author xinfei
 * @Date 2019/5/22
 * @Created add by xinfei/Kelvin 2019/5/22
 **/
public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        //（1）被监听的对象
        Subject subject = new Subject();
        subject.filterBlackList();
        subject.filterSameContent();
        subject.filterTimes();
        System.out.println("======================以下是添加监听事件之后处理=======================");

        //（2）定义日志监听者监听者
        LoggerObserver loggerObserver = new LoggerObserver(); //定义日志监听者
        StatObserver statObserver = new StatObserver(); //定义统计的观察者

        //定义监听者的回调方法
        Method method = IObserver.class.getMethod("doLogger", new Class[]{MyEvent.class});

        //（3）添加监听事件
        subject.addListener(FilterEnum.SAME_CONTENT, loggerObserver, method);
        subject.addListener(FilterEnum.TIME_FILTER, loggerObserver, method);
        subject.addListener(FilterEnum.BLACK_LIST, loggerObserver, method);
        subject.addListener(FilterEnum.SAME_CONTENT, statObserver, method);
        subject.addListener(FilterEnum.TIME_FILTER, statObserver, method);
        subject.addListener(FilterEnum.BLACK_LIST, statObserver, method);

        //（4）添加监听事件之后，被监听对象执行对应的函数
        subject.filterBlackList();
        subject.filterSameContent();
        subject.filterTimes();
    }
}
