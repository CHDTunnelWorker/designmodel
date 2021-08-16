package com.laohu.model.create.factory.simple;

/**
 * @author Holland
 * @title: IRuleConfigParser
 * @projectName designmodel
 * @description: 规则配置解析接口
 * @date 2021/8/1311:26 上午
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
