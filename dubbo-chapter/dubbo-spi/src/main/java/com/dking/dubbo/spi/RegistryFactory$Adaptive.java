package com.dking.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.RegistryFactory;

/**
 * Created by xinfei on 2018/6/29.
 */

public class RegistryFactory$Adaptive implements
        com.alibaba.dubbo.registry.RegistryFactory {
    public com.alibaba.dubbo.registry.Registry getRegistry(com.alibaba.dubbo.common.URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");

        URL url = arg0;
        String extName = (url.getProtocol() == null ? "dubbo" :url.getProtocol());
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.registry.RegistryFactory) " + "name from url(" + url.toString() + ") use keys([protocol])");

        RegistryFactory extension = (com.alibaba.dubbo.registry.RegistryFactory)ExtensionLoader.getExtensionLoader(RegistryFactory.class).getExtension(extName);

        return extension.getRegistry(arg0);
    }
}