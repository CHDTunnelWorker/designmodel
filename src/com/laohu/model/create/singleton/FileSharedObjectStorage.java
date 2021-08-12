package com.laohu.model.create.singleton;

import com.laohu.model.create.singleton.ClusterIdGenerator;

/**
 * @program: designmodel
 * @description: 外部文件共享存储区
 * @author: Holland
 * @create: 2021-08-12 16:28
 **/
public class FileSharedObjectStorage {

    //...省略从外部存储加载ClusterIdGenerator对象的实现...
    public ClusterIdGenerator loadClusterIdGenerator() {
        return null;
    }

    //...省略向外部存储存储ClusterIdGenerator对象的实现...
    public void saveClusterIdGenerator(ClusterIdGenerator idGenerator){

    }
}
