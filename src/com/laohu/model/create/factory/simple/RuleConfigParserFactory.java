package com.laohu.model.create.factory.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: designmodel
 * @description: 规则配置解析器工厂(简单工厂)
 * @author: Holland
 * @create: 2021-08-13 11:36
 **/
public class RuleConfigParserFactory {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    /**
     * @Description: 对于这种简单的创建代码, 虽然有多个if逻辑, 违背开闭原则, 但是权衡可读性和扩展性, 其实也是ok的
     * 这是第一种简单工厂的实现方式
     * @param: String configFormat
     * @return: IRuleConfigParser
     * @auther: Holland
     * @date: 2021/8/13 12:02 下午
     */
//    public static IRuleConfigParser createParser(String configFormat) {
//        IRuleConfigParser parser = null;
//        if ("json".equalsIgnoreCase(configFormat)) {
//            parser = new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(configFormat)) {
//            parser = new XmlRuleConfigParser();
//        } else if ("yaml".equalsIgnoreCase(configFormat)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(configFormat)) {
//            parser = new PropertiesRuleConfigParser();
//        }
//
//        return parser;
//    }

    /**
     * @Description: 第二种简单工厂的实现方式, 通过工厂中的map, 来保存后缀名与对应的解析器的关系, 同时将单例模式结合
     * @param: String configFormat
     * @return: IRuleConfigParser
     * @auther: Holland
     * @date: 2021/8/13 12:04 下午
     */
    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat);
        return parser;
    }

}
