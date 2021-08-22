package com.laohu.model.structure.unit.chessgame;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: designmodel
 * @description: 棋子享元对象的创建工厂(用于创建享元并缓存到内存中)
 * @author: Holland
 * @create: 2021-08-22 12:04
 **/
public class ChessPieceUnitFactory {

    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap();

    static {
        pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit(2, "馬", ChessPieceUnit.Color.BLACK));
        //...省略摆放其他棋子的代码...
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }
}
