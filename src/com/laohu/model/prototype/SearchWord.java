package com.laohu.model.prototype;

/**
 * @program: designmodel
 * @description: 关键词实体类对象
 * @author: Holland
 * @create: 2021-08-15 10:26
 **/
public class SearchWord {
    /**
     * 关键词
     */
    private String keyword;
    /**
     * 上次更新时间(毫秒时间戳)
     */
    private Long lastUpdateTime;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
