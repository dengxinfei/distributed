package com.dking.distributed.adapter.classAdapter;

/**
 * 适配器-类适配器模式
 *
 * @ClassName Adapter
 * @Author xinfei
 * @Date 2019/5/15
 * @Created add by xinfei/Kelvin 2019/5/15
 **/
public class Adapter extends Adaptee implements Target{

    @Override
    public void useShuangKong() {
        super.userSanKong();
    }
}
