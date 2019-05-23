package com.kelvin.pattern.decorator;

/**
 * 装饰者模式-具体的装饰者
 *
 * @ClassName FilterSame
 * @Author xinfei
 * @Date 2019/5/16
 * @Created add by xinfei/Kelvin 2019/5/16
 **/
public class FilterSame extends SMSDecorator {

    public FilterSame(IMessage message) {
        super(message);
    }

    //装饰者的具体装饰的实现
    @Override
    public void invoke() {
        System.out.println("我要过滤相同的内容");
        super.invoke();
    }
}
