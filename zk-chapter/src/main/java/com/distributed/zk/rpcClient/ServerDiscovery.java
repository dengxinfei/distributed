package com.distributed.zk.rpcClient;

import com.distributed.zk.rpcServer.ZKConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 获取注册到ZK上的信息
 *
 * Created by xinfei on 2018/6/13.
 */
public class ServerDiscovery {

    //ZK的连接对象
    private static CuratorFramework curatorFramework;

    private void getCuratorFramework() {
        System.out.println("启动ZK连接.............");
        curatorFramework = CuratorFrameworkFactory.builder().
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                sessionTimeoutMs(3000).
                connectString(ZKConfig.CONNNECTION_STR).build();
        curatorFramework.start();
    }

    /**
     * 获取ZK上的注册信息。
     *
     * @param path ZK上的路径
     * @return
     */
    public String getRegister(String path){
        String serviceURL = null;
        try {
            if(null == curatorFramework){
                this.getCuratorFramework();
            }
            //(1) 获取路径下的所有的子节点
            List<String> childrens = curatorFramework.getChildren().forPath(path);
            if(null == childrens || childrens.size() == 0){
                return null;
            }

            //(2)根据一定的策略选择其中一个节点，我们随机获取一个
            Random random = new Random();
            String node = childrens.get(random.nextInt(childrens.size()));

            //(3)获取服务节点之后，得到服务节点的值
            byte[] bytes = curatorFramework.getData().forPath(path + "/" + node);
            serviceURL = new String(bytes);
            System.out.println("获取节点的值=" + serviceURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceURL;
    }

//    public static void main(String[] args) {
//        ServerDiscovery serverDiscovery = new ServerDiscovery();
//        serverDiscovery.getRegister(ZKConfig.ZK_REGISTER_PATH);
//    }

}
