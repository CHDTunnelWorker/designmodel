package com.laohu.model.create.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designmodel
 * @description: 集群单例
 * @author: Holland
 * @create: 2021-08-12 16:26
 **/
public class ClusterIdGenerator {

    private AtomicLong id = new AtomicLong(0);
    private static FileSharedObjectStorage storage = new FileSharedObjectStorage();
    private static DistributedLock lock = new DistributedLock();
    private static ClusterIdGenerator instance;

    private ClusterIdGenerator() {
    }

    /**
     * @Description: 使用集群单例对象的时候, 需要将单例对象从外部存储加载至内存, 并上集群锁, 防止其他进程请求到该单例
     * @return: ClusterIdGenerator
     * @auther: Holland
     * @date: 2021/8/12 4:39 下午
     */
    public synchronized static ClusterIdGenerator getInstance() {
        if (instance == null) {
            lock.lock();
            instance = storage.loadClusterIdGenerator();
        }
        return instance;
    }

    /**
     * @Description: 使用完单例对象后, 需要将单例对象保存至外部存储, 并清空本地进程的单例引用, 然后释放集群锁, 允许其他进程请求该单例对象
     * @auther: Holland
     * @date: 2021/8/12 4:39 下午
     */
    public synchronized static void freeInstance() {
        storage.saveClusterIdGenerator(instance);
        //释放对象
        instance = null;
        lock.unlock();
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
