package com.laohu.model.structure.unit.charactor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: designmodel
 * @description: 文本编辑器
 * @author: Holland
 * @create: 2021-08-22 12:19
 **/
public class Editor {
    private List chars = new ArrayList<>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
        chars.add(character);
    }
}
