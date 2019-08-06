package cn.tenbit.research.zookeeper.core;

import org.apache.zookeeper.ZooKeeper;

/**
 * @Author bangquan.qian
 * @Date 2019-08-05 15:37
 */
public class ZkSession {

    private ZkSessionConfig config;

    private ZooKeeper session;

    public ZkSession(ZkSessionConfig config, ZooKeeper session) {
        this.config = config;
        this.session = session;
    }

    public ZkSessionConfig getConfig() {
        return config;
    }

    public ZooKeeper getSession() {
        return session;
    }
}
