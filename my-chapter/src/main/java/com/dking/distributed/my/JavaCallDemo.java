package com.dking.distributed.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Java的引用调用的方式测试
 *
 * @ClassName JavaCallDemo
 * @Author xinfei
 * @Date 2018/8/14 17:02
 **/
public class JavaCallDemo {


    public static void main(String[] args) {
        List<String> userList = new ArrayList<>();
        userList.add("1");
        userList.add("2");
        userList.add("3");
        userList.add("4");
        userList.add("5");
        MyObject myObject = new MyObject();
        myObject.setUserList(userList);

        List<Object> filter = Arrays.asList(userList.toArray());
        System.out.println("过滤前LIST的长度：" + myObject.getUserList().size());
        new JavaCallDemo().filterUser(myObject.getUserList());
        System.out.println("过滤后LIST的长度：" + filter.size());
        System.out.println("");

    }





    public void filterUser(List userList){
        userList.remove("3");
        System.out.println("函数中的长度：" + userList.size());
    }



}
