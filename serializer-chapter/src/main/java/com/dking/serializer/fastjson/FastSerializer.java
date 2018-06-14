package com.dking.serializer.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dking.serializer.ISerializer;

import java.io.*;

/**
 * 使用Java的原始方式实现序列化以及反序列化
 *
 * Created by xinfei on 2018/6/2.
 */
public class FastSerializer implements ISerializer{

    /**
     * FastJson的原始方式实现序列化。将内容流化，将数据从内存中取出来。
     *
     * @param obj 需要序列化的对象
     * @param <T>
     * @return
     */
    public <T> byte[] serializer(T obj) throws IOException {
        String result = JSON.toJSONString(obj);
        return result.getBytes();
    }

    /**
     * FastJson的原始方法实现反序列化
     *
     * @param data 二进制数组
     * @param clazz 返序列化之后的类型
     * @param <T>
     * @return
     */
    public <T> T deSerializer(byte[] data, Class<T> clazz) throws IOException {
        String value = new String(data);
        return (T)JSON.parseObject(value, clazz);
    }
}
