package com.laohu.model.structure.unit.chessgame;

/**
 * @program: designmodel
 * @description: 棋子对象
 * @author: Holland
 * @create: 2021-08-22 12:06
 **/
public class ChessPiece {
    /**
     * 引用享元对象
     */
    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit unit, int positionX, int positionY) {
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // 省略getter、setter方法}

}
