package com.distributed.zk.rpcServer;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * Created by xinfei on 2018/6/12.
 */
public class RegisterCenter {

    /**
     * 将当前服务注册到ZK上
     *
     * @param serviceName 服务名称
     * @param serverValue 服务值
     */
    public static void register(String serviceName, String serverValue){
        CuratorFramework curatorFramework= CuratorFrameworkFactory.builder().
                connectString(ZKConfig.CONNNECTION_STR).
                sessionTimeoutMs(4000).
                retryPolicy(new ExponentialBackoffRetry(1000,
                        3)).build();
        curatorFramework.start();

        //判断根节点存在，不存在创建
        try {
            Stat stat = curatorFramework.checkExists().forPath(ZKConfig.ZK_REGISTER_PATH);
            if(null == stat){
                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(ZKConfig.ZK_REGISTER_PATH);
            }

            //创建临时节点，
            String result = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(ZKConfig.ZK_REGISTER_PATH + "/" + serviceName, serverValue.getBytes());
            System.out.println("节点创建成功-》" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
