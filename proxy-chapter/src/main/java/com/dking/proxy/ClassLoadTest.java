package com.dking.proxy;

/**
 * 测试CLASS_LOAD
 *
 * Created by xinfei on 2018/6/13.
 */
public class ClassLoadTest {


    public static void main(String[] args) {
        try {
            ISubject subject = new RelSubject();
            ClassLoader classLoader = ISubject.class.getClassLoader();
            ISubject s = RelSubject.class.newInstance();
            System.out.println("xxxxxxxxxxxxxxxx");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
