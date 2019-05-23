package com.dking.distributed.adapter.objAdapter;

import com.dking.distributed.adapter.classAdapter.SanKong;

/**
 * 适配器-适配者，实现客户端最终想实现的功能
 *
 * @ClassName Adaptee
 * @Author xinfei
 * @Date 2019/5/15
 * @Created add by xinfei/Kelvin 2019/5/15
 **/
public class Adaptee implements SanKong {

    @Override
    public void userSanKong() {
        System.out.println("对象适配模式：三孔插座开始工作");
    }
}
