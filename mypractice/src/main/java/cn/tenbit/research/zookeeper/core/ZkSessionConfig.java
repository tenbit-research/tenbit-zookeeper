package cn.tenbit.research.zookeeper.core;

/**
 * @Author bangquan.qian
 * @Date 2019-08-05 15:51
 */
public class ZkSessionConfig {

    public static final int DEFAULT_TIMEOUT_MS = 2000;

    private String url;

    private int timeout = DEFAULT_TIMEOUT_MS;

    private boolean readOnly;

    public ZkSessionConfig(String url, int timeout) {
        this.url = url;
        this.timeout = timeout;
    }

    public ZkSessionConfig(String url, int timeout, boolean readOnly) {
        this.url = url;
        this.timeout = timeout;
        this.readOnly = readOnly;
    }

    public ZkSessionConfig(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public int getTimeout() {
        return timeout;
    }

    public boolean isReadOnly() {
        return readOnly;
    }
}
