package com.dking.dubbo;

/**
 * 创建一个DUBBO服务实例
 *
 * Created by xinfei on 2018/6/19.
 */
public interface IDubboService {

    /**
     * 提供服务端的接口方法
     *
     * @param msg 传入的消息内容
     * @return 服务端返回消息处理结果
     */
    String sayHello(String msg);


}
