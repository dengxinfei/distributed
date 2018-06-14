package com.dking.serializer.fastjson;

import com.dking.serializer.ISerializer;
import com.dking.serializer.Person;
import com.dking.serializer.java.JavaSerializer;

import java.io.IOException;

/**
 * 执行序列化以及反序列化
 *
 * Created by xinfei on 2018/6/2.
 */
public class FastMain {

    public static void main(String[] args) throws IOException {
        //(1)序列化
        Person person = new Person("DKing", 18, 1);
        ISerializer fastSerializer = new FastSerializer();
        byte[] bytes = fastSerializer.serializer(person);
        System.out.println(bytes);

        //(2)反序列化
        Person p = fastSerializer.deSerializer(bytes, Person.class);
        System.out.println(p);

    }

}
