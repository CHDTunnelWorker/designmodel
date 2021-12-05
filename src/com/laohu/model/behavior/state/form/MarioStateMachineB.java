package com.laohu.model.behavior.state.form;

import com.laohu.model.behavior.state.branch.State;

import static com.laohu.model.behavior.state.branch.State.*;
import static com.laohu.model.behavior.state.form.Event.*;

/**
 * @program: designmodel
 * @description: 查表法实现 适用于动作逻辑简单场景，该方法可读性和可维护性强
 * 第一维表示当前状态，第二维表示事件，值表示当前状态经过事件之后，转移到的新状态及其执行的动作
 * @author: Holland
 * @create: 2021-12-05 21:39
 **/
public class MarioStateMachineB {

    private int score;
    private State currentState;

    /**
     * 表状态值
     */
    private static final State[][] transitionTable = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}
    };

    /**
     * 表积分值
     */
    private static final int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}
    };

    public MarioStateMachineB() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 吃蘑菇
     */
    public void obtainMushRoom() {
        executeEvent(GOT_MUSHROOM);
    }

    /**
     * 获得斗篷
     */
    public void obtainCape() {
        executeEvent(GOT_CAPE);
    }

    /**
     * 吃火焰花
     */
    public void obtainFireFlower() {
        executeEvent(GOT_FIRE);
    }

    /**
     * 碰到怪兽
     */
    public void meetMonster() {
        executeEvent(MET_MONSTER);
    }

    /**
     * 查表操作
     * @param event
     */
    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score += actionTable[stateValue][eventValue];
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
