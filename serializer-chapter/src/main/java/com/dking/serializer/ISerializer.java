package com.dking.serializer;

import java.io.IOException;

/**
 *
 * 序列化，以及返序列h化
 *
 * Created by xinfei on 2018/6/2.
 */
public interface ISerializer {

    /**
     *
     * 实现序列化一个对象
     *
     * @param obj 需要序列化的对象
     * @param <T> 序列化的对象的类型
     * @return 返回序列化的二进制数组
     */
     <T> byte[] serializer(T obj) throws IOException;

    /**
     * 将二进制数据对象返序列化
     *
     * @param data 二进制数组
     * @param clazz 返序列化之后的类型
     * @param <T> 类的范型
     * @return 返回对象
     */
      <T> T deSerializer(byte[] data, Class<T> clazz) throws IOException;



}
