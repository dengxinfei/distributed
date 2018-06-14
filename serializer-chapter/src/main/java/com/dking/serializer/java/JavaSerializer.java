package com.dking.serializer.java;

import com.dking.serializer.ISerializer;
import java.io.*;

/**
 * 使用Java的原始方式实现序列化以及反序列化
 *
 * Created by xinfei on 2018/6/2.
 */
public class JavaSerializer implements ISerializer{

    /**
     * Java的原始方式实现序列化。将内容流化，将数据从内存中取出来。
     *
     * @param obj 需要序列化的对象
     * @param <T>
     * @return
     */
    public <T> byte[] serializer(T obj) throws IOException {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            //(1) 定义一个字节输出流，接收序列化的对象
            baos = new ByteArrayOutputStream();

            //(2) 定义对象输出流， 并将对象写入到流中
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.flush();

            //(3) 转换成字节数组
            byte[] bytes = baos.toByteArray();
            return bytes;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != oos){
                oos.close();
            }
            if(null != baos){
                baos.close();
            }
        }
        return new byte[0];
    }

    /**
     * Java的原始方法实现反序列化
     *
     * @param data 二进制数组
     * @param clazz 返序列化之后的类型
     * @param <T>
     * @return
     */
    public <T> T deSerializer(byte[] data, Class<T> clazz) throws IOException {
        ObjectInputStream objectInputStream = null;
        if(null == data){
            return null;
        }

        //开始进行反序列化
        try{
            //(1)将byte[]数组，内容进行流化，转换成数组字节流
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

            //(2)将字节流， 转换成对象输入流。
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return (T)objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != objectInputStream){
                objectInputStream.close();
            }
        }

        return null;
    }
}
