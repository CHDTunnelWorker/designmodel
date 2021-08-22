package com.laohu.model.structure.unit.chessgame;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: designmodel
 * @description: 棋盘对象
 * @author: Holland
 * @create: 2021-08-22 12:07
 **/
public class ChessBoard {

    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
        chessPieces.put(2, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 1, 0));

        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
