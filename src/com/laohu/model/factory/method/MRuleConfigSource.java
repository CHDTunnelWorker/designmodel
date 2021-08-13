package com.laohu.model.factory.method;

import com.laohu.model.factory.simple.IRuleConfigParser;
import com.laohu.model.factory.simple.RuleConfig;

/**
 * @program: designmodel
 * @description: 工厂方法下实现的规则配置源
 * @author: Holland
 * @create: 2021-08-13 14:30
 **/
public class MRuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryBuilder.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new RuntimeException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
