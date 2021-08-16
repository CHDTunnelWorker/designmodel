package com.laohu.model.create.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: designmodel
 * @description: 将数据库更新数据同步更新至内存, 此时要求内存中的数据必须是同一个版本的数据
 * 1.如果一次性查出所有数据放入,那么IO成本太高;由于每次更新的数据不多,那么可以先将没更新的数据进行浅拷贝,对于更新的数据进行深拷贝,并放入内存中;实现需求中的要求
 * @author: Holland
 * @create: 2021-08-15 10:49
 **/
public class NewDemo {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    private long lastUpdateTime = -1;

    public void refresh() {
        //先浅拷贝数据
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();

        //从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;

        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                newKeywords.remove(searchWord.getKeyword());
            }
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }

        lastUpdateTime = maxNewUpdateTime;
        //将新版本数据,统一将引用修改为currentKeywords
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //...省略获取数据库中最后一次更新时间戳大于lastUpdateTime的数据逻辑...
        return new ArrayList<>();
    }
}
