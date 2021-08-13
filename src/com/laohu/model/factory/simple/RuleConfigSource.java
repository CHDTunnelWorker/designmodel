package com.laohu.model.factory.simple;

/**
 * @program: designmodel
 * @description: 规则配置源
 * @author: Holland
 * @create: 2021-08-13 11:39
 **/
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new RuntimeException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String ruleConfigFilePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
