package cn.tenbit.research.zookeeper.core;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @Author bangquan.qian
 * @Date 2019-08-05 15:48
 */
public class ZkSessionFactory {

    public ZkSession createSession(ZkSessionConfig config) throws IOException {
        return createSession(config, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
            }
        });
    }

    public ZkSession createSession(ZkSessionConfig config, Watcher watcher) throws IOException {
        ZooKeeper zk = new ZooKeeper(config.getUrl(), config.getTimeout(), watcher, config.isReadOnly());
        return new ZkSession(config, zk);
    }
}
