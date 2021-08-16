package com.laohu.model.create.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: designmodel
 * @description: 将数据库更新的数据更新至内存中关键词map的旧实现Demo(旧版本数据与新版本数据混合在一起)
 * @author: Holland
 * @create: 2021-08-15 10:28
 **/
public class OldDemo {
    /**
     * 当前关键词对象map
     */
    private ConcurrentHashMap<String, SearchWord> currentKeywords = new ConcurrentHashMap<>();
    /**
     * 最后一次更新时间戳
     */
    private long lastUpdateTime = -1;

    public void refresh(){
        //从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;

        for (SearchWord searchWord : toBeUpdatedSearchWords) {

            if(searchWord.getLastUpdateTime() > lastUpdateTime){
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }

            //有需要更新的数据,则直接替换;无数据则新增放入
            if(currentKeywords.containsKey(searchWord.getKeyword())){
                currentKeywords.replace(searchWord.getKeyword(), searchWord);
            } else {
                currentKeywords.put(searchWord.getKeyword(), searchWord);
            }

        }

        lastUpdateTime = maxNewUpdatedTime;
    }


    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //...省略获取数据库中最后一次更新时间戳大于lastUpdateTime的数据逻辑...
        return new ArrayList<>();
    }
}
