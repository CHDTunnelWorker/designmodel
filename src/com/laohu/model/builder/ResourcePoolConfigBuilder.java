package com.laohu.model.builder;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @program: designmodel
 * @description: 资源池配置类builder
 * @author: Holland
 * @create: 2021-08-14 16:28
 **/
public class ResourcePoolConfigBuilder {

    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    protected String name;
    protected int maxTotal = DEFAULT_MAX_TOTAL;
    protected int maxIdle = DEFAULT_MAX_IDLE;
    protected int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig build() {
        //复杂的参数校验逻辑,统一放到builder方法中去处理,包括必填项校验、依赖关系校验、约束条件校验等
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("...");
        }
        if (maxIdle > maxTotal) {
            throw new IllegalArgumentException("...");
        }
        if (minIdle > maxTotal || minIdle > maxIdle) {
            throw new IllegalArgumentException("...");
        }
        return new ResourcePoolConfig(this);
    }

    public ResourcePoolConfigBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("...");
        }
        this.name = name;
        return this;
    }

    public ResourcePoolConfigBuilder setMaxTotal(int maxTotal) {
        if (maxTotal <= 0) {
            throw new IllegalArgumentException("...");
        }
        this.maxTotal = maxTotal;
        return this;
    }

    public ResourcePoolConfigBuilder setMaxIdle(int maxIdle) {
        if (maxIdle < 0) {
            throw new IllegalArgumentException("...");
        }
        this.maxIdle = maxIdle;
        return this;
    }

    public ResourcePoolConfigBuilder setMinIdle(int minIdle) {
        if (minIdle < 0) {
            throw new IllegalArgumentException("...");
        }
        this.minIdle = minIdle;
        return this;
    }
}
