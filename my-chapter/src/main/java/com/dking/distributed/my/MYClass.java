package com.dking.distributed.my;

import com.dking.distributed.parent.ParentClass;

public class MYClass extends ParentClass {

    private int num = 10;

    public MYClass(){
    }

    public void doTest(){
        System.out.println("子类：" + this.num);
        super.doLogin(this);
    }








}
