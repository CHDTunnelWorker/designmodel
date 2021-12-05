package com.laohu.model.behavior.state.branch;

/**
 * @program: designmodel
 * @description: 分支逻辑法实现的马里奥状态机，包含大量if else逻辑 维护性差，只适用于状态简单，逻辑简单的场景
 * @author: Holland
 * @create: 2021-12-05 21:39
 **/
public class MarioStateMachineA {

    private int score;
    private State currentState;

    public MarioStateMachineA() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 吃蘑菇
     */
    public void obtainMushRoom() {
        if (currentState.equals(State.SMALL)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    /**
     * 获得斗篷
     */
    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    /**
     * 吃火焰花
     */
    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    /**
     * 碰到怪兽
     */
    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }
        if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
