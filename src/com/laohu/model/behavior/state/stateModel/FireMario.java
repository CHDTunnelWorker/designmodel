package com.laohu.model.behavior.state.stateModel;

import com.laohu.model.behavior.state.branch.State;

/**
 * @program: designmodel
 * @description: Fire状态类
 * @author: Holland
 * @create: 2021-12-05 22:03
 **/
public class FireMario implements IMario {

    private static final FireMario instance = new FireMario();

    private FireMario() {
    }

    public static FireMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.FIRE;
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
