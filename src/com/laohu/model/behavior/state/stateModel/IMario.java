package com.laohu.model.behavior.state.stateModel;

import com.laohu.model.behavior.state.branch.State;

/**
 * @program: designmodel
 * @description: 定义动作接口
 * @author: Holland
 * @create: 2021-12-05 21:59
 **/
public interface IMario {

    State getName();

    void obtainMushRoom(MarioStateMachineC stateMachine);

    void obtainCape(MarioStateMachineC stateMachine);

    void obtainFireFlower(MarioStateMachineC stateMachine);

    void meetMonster(MarioStateMachineC stateMachine);
}
