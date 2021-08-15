package com.laohu.model.builder;

/**
 * @program: designmodel
 * @description: 资源池配置类,不提供set方法,所以建造者模式创建的对象,是无法进行再次修改的
 * @author: Holland
 * @create: 2021-08-14 16:28
 **/
public class ResourcePoolConfig {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    public ResourcePoolConfig(ResourcePoolConfigBuilder builder){
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }
}
