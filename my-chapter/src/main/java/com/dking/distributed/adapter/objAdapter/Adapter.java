package com.dking.distributed.adapter.objAdapter;

/**
 * 适配器-对象适配器模式
 *
 * @ClassName Adapter
 * @Author xinfei
 * @Date 2019/5/15
 * @Created add by xinfei/Kelvin 2019/5/15
 **/
public class Adapter implements Target{

    //对象适配模式跟类适配模式的区别就是，对象适配模式在适配类当中，持有适配者的引用，而不需要继承适配者 adaptee
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }


    @Override
    public void useShuangKong() {
        adaptee.userSanKong();
    }
}
