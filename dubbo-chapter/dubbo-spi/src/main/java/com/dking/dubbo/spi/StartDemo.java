package com.dking.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

/**
 * Created by xinfei on 2018/6/23.
 */
public class StartDemo {



    public static void main(String[] args) {
       //Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("registry");

    }
}
