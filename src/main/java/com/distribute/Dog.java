package com.distribute;

/**
 * Created by xinfei on 2018/6/6.
 */
public class Dog extends Animal {

    private String name;

    private int age;

    public Dog(){
        super();
        System.out.println(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
