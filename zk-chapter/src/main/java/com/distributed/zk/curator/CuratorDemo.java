package com.distributed.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 *
 * 使用curator的方式，操作ZK, 并设置监听
 * 1、使用curator的方式连接ZK
 * 2、使用curator的方式创建节点
 * 3、使用curator的方式设置监听的方式
 *
 * Created by xinfei on 2018/6/12.
 */
public class CuratorDemo {

    public static void main(String[] args) {
        //(1)使用curator的方式连接ZK
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("127.0.0.1:1111,127.0.0.1:2222,127.0.0.1:333").
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                namespace("xinfei_Curator").sessionTimeoutMs(3000).build();

        //(2)启动ZK的连接. (这里不需要再设置线程等待，curator已经封装了直接等到ZK的状态变成connected.)
        curatorFramework.start();
        System.out.println("zk集群连接成功........");

        try {
            //(3)删除节点
            curatorFramework.delete().deletingChildrenIfNeeded().forPath("/xinfei");

            //(4)创建节点
            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/xinfei", "999".getBytes());

            //(5)获取节点数据
            Stat stat = new Stat();
            curatorFramework.getData().storingStatIn(stat).forPath("/xinfei");

            //(6)更新节点数据
            stat = curatorFramework.setData().withVersion(stat.getAversion()).forPath("/xinfei", "777".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
