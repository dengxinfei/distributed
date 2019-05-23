package com.kelvin.jvm.classloader;

/**
 * @ClassName ClassLoaderTest
 * @Author xinfei
 * @Date 2019/3/6
 * @Created add by xinfei/Kelvin 2019/3/6
 **/
public class ClassLoaderTest {


    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader()); //APP classloader
        System.out.println(ClassLoader.getSystemClassLoader().getParent()); //extension classloader
        //Extension classloader的父的类加载器，Bootstrap 的类加载器是C++写的，获取不到
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent()); //bootstrap classloader

        //System.out.println(System.getProperty("java.class.path"));

        System.out.println(System.getProperty("java.ext.dirs"));


    }
}
