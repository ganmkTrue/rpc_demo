package com.xiyuan.common.utils;
import com.xiyuan.common.model.ResponseResult;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

public class CuratorUtils {


    private static String connectString = "47.94.101.75:2181";


    /**
     * 创建节点
     * @param path
     * @param value
     * @throws Exception
     */
    public static void createNode(String path,Object value) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 30000);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        curatorFramework.start();
        curatorFramework.create().
                creatingParentsIfNeeded().//递归创建,如果没有父节点,自动创建父节点
                withMode(CreateMode.PERSISTENT).//设置节点类型
                withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).
                forPath(path, FastJsonUtils.convertObjectToJSON(value).getBytes());
        curatorFramework.close();
    }

    /**
     * 获取节点
     * @param path
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Object getNode(String path, Class<?> clazz) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 30000);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        curatorFramework.start();

        byte[] data = curatorFramework.
                getData().
                forPath(path);

        curatorFramework.getData().usingWatcher(new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("watch机制触发" + watchedEvent);
            }
        });
        curatorFramework.close();
        return FastJsonUtils.convertJsonToObject(new String(data),clazz);
    }


    /**
     * 设置结点
     * @param path
     * @param value
     * @throws Exception
     */
    public static void SetNode(String path,Object value) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 30000);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        curatorFramework.start();
        Stat stat = curatorFramework.setData().
                withVersion(-1).
                forPath(path, FastJsonUtils.convertObjectToJSON(value).getBytes());
        curatorFramework.close();
    }


    /**
     * 删除结点
     * @param path
     * @throws Exception
     */
    public static void deleteNode(String path) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 30000);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        curatorFramework.start();
        curatorFramework.delete().deletingChildrenIfNeeded().forPath(path);
        curatorFramework.close();
    }


    public static void main(String[] args) {
        try {
            String path ="/services";
            ResponseResult responseResult =ResponseResult.success("haha");
            //创建结点
            createNode(path,responseResult);
            //获取结点
            ResponseResult result =(ResponseResult) getNode(path,ResponseResult.class);
            System.out.println(result);

        }catch (Exception e){
            System.out.println("zookeeper操作异常"+e.getMessage());
        }

    }

}

