package strategy.duck.behavior.impl;

import strategy.duck.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly no way!");
    }
}
