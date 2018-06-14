package com.distributed.zk.rpcServer;

import com.distributed.zk.IHandle;

/**
 * Created by xinfei on 2018/6/12.
 */
public class HandleImpl implements IHandle {


    public String sayHello(String str) {
        return "你好：" + str;
    }
}
