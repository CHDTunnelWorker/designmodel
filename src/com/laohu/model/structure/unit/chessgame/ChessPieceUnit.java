package com.laohu.model.structure.unit.chessgame;

import java.awt.*;

/**
 * @program: 享元模式
 * @description: 棋子享元类, 由于棋子的id, 文本和颜色在任何情况下都是固定的, 仅位置在不同棋局中不同,
 * 因此将棋子的这三个属性抽出,做成享元对象,供棋子对象引用,大大减少了因为创建相同棋子的内存占用
 * @author: Holland
 * @create: 2021-08-22 12:01
 **/
public class ChessPieceUnit {

    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public static enum Color {RED, BLACK}

    // ...省略其他属性和getter方法...
}
