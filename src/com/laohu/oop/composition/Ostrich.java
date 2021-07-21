package com.laohu.oop.composition;

/**
 * @program: designmodel
 * @description: 鸵鸟--会叫和下蛋,但是不会飞,使用接口拥有能力
 * @author: Holland
 * @create: 2021-07-21 22:27
 **/
public class Ostrich implements Tweetable, Eggable{
    //组合
    private EggAbility eggAbility = new EggAbility();
    //组合
    private FlyAbility flyAbility = new FlyAbility();

    /**
     * 下蛋和叫的逻辑可以复用,因此创建三个实体类分别继承飞,下蛋,叫接口,进行内容实现
     * 再通过组合和委托,将鸵鸟类的接口实现进行代码复用
     */
    @Override
    public void egg() {
        //委托
        eggAbility.egg();
    }

    @Override
    public void tweet() {
        //委托
        flyAbility.fly();
    }
}
