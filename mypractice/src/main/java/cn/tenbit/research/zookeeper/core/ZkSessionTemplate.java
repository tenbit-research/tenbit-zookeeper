package cn.tenbit.research.zookeeper.core;

import cn.tenbit.hare.core.lite.util.HareInvokeUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-08-05 15:48
 */
public class ZkSessionTemplate {

    private ZkSession session;

    public ZkSessionTemplate(ZkSession session) {
        this.session = session;
    }

    public ZooKeeper getSession() {
        return session.getSession();
    }

    public ZkSessionConfig getConfig() {
        return session.getConfig();
    }

    public void close() throws InterruptedException {
        getSession().close();
    }

    public String create(String path, byte[] data) {
        return HareInvokeUtils.invokeWithTurnRe(() -> {
            return getSession().create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        });
    }

    public List<String> list(String path) {
        return HareInvokeUtils.invokeWithTurnRe(() -> {
            return getSession().getChildren(path, false);
        });
    }

    public List<String> list(String path, Watcher watcher) {
        return HareInvokeUtils.invokeWithTurnRe(() -> {
            return getSession().getChildren(path, watcher);
        });
    }
}
