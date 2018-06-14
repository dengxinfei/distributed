package com.distributed.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * 使用curator的方式监听节点的变化
 *
 *
 * Created by xinfei on 2018/6/12.
 */
public class CuratorWatchDemo {

    public static void main(String[] args) {
        //(1)使用curator的方式连接ZK
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("127.0.0.1:1111,127.0.0.1:2222,127.0.0.1:333").
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                namespace("curator").sessionTimeoutMs(3000).build();

        //(2)启动ZK的连接. (这里不需要再设置线程等待，curator已经封装了直接等到ZK的状态变成connected.)
        curatorFramework.start();
        System.out.println("zk集群连接成功........");

        try {
            //(3)创建节点
            //curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/xinfei", "10".getBytes());

            //(4)当前节点的事件监听(修改，删除)
            //CuratorWatchDemo.addNodeCacheListener(curatorFramework, "/xinfei");


            //(5)添加子节点事件的监听(新增，修改，删除)
            CuratorWatchDemo.addChildrenCacheListener(curatorFramework, "/xinfei");

            System.in.read();
            curatorFramework.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加当前节点的事件监听
     *
     * @param curatorFramework ZK
     * @param path 监听的路径
     */
    public static void addNodeCacheListener(CuratorFramework curatorFramework, String path) throws Exception {
        //(1) 生成监听的NODE
        final NodeCache nodeCache = new NodeCache(curatorFramework, path, false);

        //(2)生成NodeCache监听事件
        NodeCacheListener nodeCacheListener = new NodeCacheListener() {
            public void nodeChanged() throws Exception {
                System.out.println("NodeChanged: 收到节点变化事件" + nodeCache.getCurrentData());
            }
        };

        //(3)添加监听
        nodeCache.getListenable().addListener(nodeCacheListener);
        nodeCache.start();
    }

    /**
     * 添加子节点的监听
     *
     * @param curatorFramework ZK
     * @param path 监听的路径
     */
    public static void addChildrenCacheListener(CuratorFramework curatorFramework, String path) throws Exception {
        //(1)生成子节点监听的NODE
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, path, true);

        //(2)配置子节点监听，回调事件
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("子节点事件监听： " + pathChildrenCacheEvent.toString());
            }
        };

        //(3)建立关联监听
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        pathChildrenCache.start();
    }

    /**
     * 添加当前节点以及子节点的综合监听
     * 当前版本不支持，暂无法演示
     *
     * @param curatorFramework ZK
     * @param path 监听的路径
     */
    public static void addTreeCacheListener(CuratorFramework curatorFramework, String path){
        //(1)生成子节点监听的NODE


        //(2)配置子节点监听，回调事件


        //(3)建立关联监听

    }

}
