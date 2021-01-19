package strategy.duck.behavior.impl;

import strategy.duck.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("flying duck");
    }
}
