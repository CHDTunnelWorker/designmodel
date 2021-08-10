package com.laohu.standard.practice.idgenerator.newOpti;

/**
 * @program: designmodel
 * @description: id生成异常
 * @author: Holland
 * @create: 2021-08-10 16:59
 **/
public class IdGenerationFailureException extends Exception {

    public IdGenerationFailureException(String msg) {
        super(msg);
    }
}
