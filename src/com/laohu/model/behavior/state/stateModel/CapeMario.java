package com.laohu.model.behavior.state.stateModel;

import com.laohu.model.behavior.state.branch.State;

/**
 * @program: designmodel
 * @description: Cape状态类
 * @author: Holland
 * @create: 2021-12-05 22:03
 **/
public class CapeMario implements IMario {

    private static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachineC stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachineC stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachineC stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachineC stateMachine) {

    }
}
