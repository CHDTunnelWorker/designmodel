package com.laohu.model.factory.method;

import com.laohu.model.factory.simple.IRuleConfigParser;

/**
 * @author Holland
 * @title: IRuleConfigParserFactory
 * @projectName designmodel
 * @description: 规则配置解析器工厂接口,新增一个parser,只需要新增一个parser,和继承该接口的parser工厂类即可,也是工厂方法模式的典型实现
 * 所以工厂方法这个实现工厂模式,比简单工厂更加符合开闭原则,但是在这个简单创建对象的场景下,实现比简单工厂复杂的多
 * @date 2021/8/1312:18 下午
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
