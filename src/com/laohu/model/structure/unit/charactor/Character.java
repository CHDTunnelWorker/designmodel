package com.laohu.model.structure.unit.charactor;

/**
 * @program: designmodel
 * @description: 文字对象
 * @author: Holland
 * @create: 2021-08-22 12:18
 **/
public class Character {
    private java.lang.Character c;
    /**
     * 引用文字格式的享元对象
     */
    private CharacterStyle style;

    public Character(char c, CharacterStyle style) {
        this.c = c;
        this.style = style;
    }
}
