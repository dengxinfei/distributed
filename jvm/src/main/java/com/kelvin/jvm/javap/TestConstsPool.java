package com.kelvin.jvm.javap;

import java.io.Serializable;

/**
 * @ClassName ConstsPool
 * @Author xinfei
 * @Date 2019/5/8
 * @Created add by xinfei/Kelvin 2019/5/8
 **/
public class TestConstsPool implements TIF {

    private int i = 10;
    private byte aByte = 1;
    private short aShort = 2;
    private char aChar = 's';
    private boolean aBoolean = true;
    private String str = "Hello World";

    private final int a = 5;

    private final static int b = 10;

    public void setAge(int age){
        int vv = i + 10;
    }

    public int getAge(String name){
        byte a = this.aByte;
        return 30;
    }

    public static void main(String[] args){
        TestConstsPool pool = new TestConstsPool();
        pool.setAge(10);
        int age2 = pool.getAge("");
    }

    public void testInterface() {

    }
}
