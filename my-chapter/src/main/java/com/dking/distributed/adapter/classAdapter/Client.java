package com.dking.distributed.adapter.classAdapter;

/**
 * 适配器客户端类
 *
 * @ClassName Client
 * @Author xinfei
 * @Date 2019/5/15
 * @Created add by xinfei/Kelvin 2019/5/15
 **/
public class Client {

    //适配器客户端类持有目标接口的引用，但是目标接口中没有适合的方法。
    //但是应外一个接口中的方式比较适合，所以引用适配类，去适配我想调用的方法。
    //有点挂着羊头卖狗肉的感觉
    public static void main(String[] args) {
        Target target = new Adapter();
        target.useShuangKong();
    }
}
