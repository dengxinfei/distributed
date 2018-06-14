package com.dking.serializer.java;

import com.dking.serializer.ISerializer;
import com.dking.serializer.Person;

import java.io.IOException;

/**
 * 执行序列化以及反序列化
 *
 * Created by xinfei on 2018/6/2.
 */
public class JavaMain {

    public static void main(String[] args) throws IOException {
        //(1)序列化
        Person person = new Person("DKing", 18, 1);
        ISerializer javaSerializer = new JavaSerializer();
        byte[] bytes = javaSerializer.serializer(person);
        System.out.println(bytes);

        //(2)反序列化
        Person p = javaSerializer.deSerializer(bytes, Person.class);
        System.out.println(p);

    }

}
