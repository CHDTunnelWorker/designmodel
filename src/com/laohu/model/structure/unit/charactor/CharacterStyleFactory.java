package com.laohu.model.structure.unit.charactor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: designmodel
 * @description: 文字格式享元对象创建工厂
 * @author: Holland
 * @create: 2021-08-22 12:15
 **/
public class CharacterStyleFactory {

    private static final List<CharacterStyle> styles = new ArrayList<>();

    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style : styles) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}
