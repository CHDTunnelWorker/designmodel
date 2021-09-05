package com.laohu.model.behavior.observer.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: designmodel
 * @description: 标注观察者的哪个函数可以接受消息
 * @author: Holland
 * @create: 2021-09-05 14:28
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {
}
