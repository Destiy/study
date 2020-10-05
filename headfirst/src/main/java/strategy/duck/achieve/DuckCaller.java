package strategy.duck.achieve;

import strategy.duck.behavior.QuackBehavior;
import strategy.duck.behavior.impl.Quack;

public class DuckCaller {

    private QuackBehavior quackBehavior;

    public DuckCaller() {
        this.quackBehavior = new Quack();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
    public static void main(String[] args) {
        DuckCaller duckCaller = new DuckCaller();
        duckCaller.performQuack();
    }
}
