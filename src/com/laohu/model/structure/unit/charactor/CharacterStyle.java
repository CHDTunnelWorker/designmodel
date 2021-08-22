package com.laohu.model.structure.unit.charactor;

import java.awt.*;

/**
 * @program: designmodel
 * @description: 文本格式对象(实际上, 在文本中, 不大可能每个文字都有不同的格式, 大多都是一样的格式)
 * 因此,我们可以将格式字段抽出,组成享元对象,供文字对象引用
 * @author: Holland
 * @create: 2021-08-22 12:13
 **/
public class CharacterStyle {

    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object o) {
        CharacterStyle otherStyle = (CharacterStyle) o;
        return font.equals(otherStyle.font) && size == otherStyle.size && colorRGB == otherStyle.colorRGB;
    }
}
