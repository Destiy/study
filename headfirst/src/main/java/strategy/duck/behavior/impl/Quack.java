package strategy.duck.behavior.impl;

import strategy.duck.behavior.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack Quack!");
    }
}
