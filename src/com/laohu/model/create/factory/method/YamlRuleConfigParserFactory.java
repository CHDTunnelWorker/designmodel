package com.laohu.model.create.factory.method;

import com.laohu.model.create.factory.simple.IRuleConfigParser;
import com.laohu.model.create.factory.simple.YamlRuleConfigParser;

/**
 * @program: designmodel
 * @description: yaml规则配置解析器工厂类
 * @author: Holland
 * @create: 2021-08-13 12:21
 **/
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
