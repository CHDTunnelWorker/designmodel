package com.laohu.model.factory.method;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @program: designmodel
 * @description: 规则配置解析器工厂建造类, 生成工厂类的工厂
 * @author: Holland
 * @create: 2021-08-13 14:25
 **/
public class RuleConfigParserFactoryBuilder {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new JsonRuleConfigParserFactory());
        cachedFactories.put("yaml", new JsonRuleConfigParserFactory());
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}
