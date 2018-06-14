package com.distributed.zk.rpcServer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinfei on 2018/6/12.
 */
public class ZKConfig {


    public final static String CONNNECTION_STR="127.0.0.1:2222";

    public final static String ZK_REGISTER_PATH="/registrys";

    public static Map<String, Object> serviceMap = new HashMap<String, Object>();

}
