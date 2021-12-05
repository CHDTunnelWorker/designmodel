package com.laohu.model.behavior.state.stateModel;

import com.laohu.model.behavior.state.branch.State;

/**
 * @program: designmodel
 * @description: 状态模式实现的状态机
 * 适用于动作逻辑复杂的业务场景，如电商订单的状态等，该模式是将分支逻辑法中的逻辑，基于状态将逻辑拆分到各自
 * 的状态类中去实现（其中状态类由于不包含成员变量，可以设置为单例）
 * @author: Holland
 * @create: 2021-12-05 21:59
 **/
public class MarioStateMachineC {
    private int score;
    private IMario currentState;

    public MarioStateMachineC() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState.getName();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
