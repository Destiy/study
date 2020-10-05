package strategy.duck;

import strategy.duck.behavior.FlyBehavior;
import strategy.duck.behavior.QuackBehavior;

public abstract class Duck {

    /**
     * quack interface
     */
    protected QuackBehavior quackBehavior;
    /**
     * fly interface
     */
    protected FlyBehavior flyBehavior;

    public abstract void display();

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys");
    }

}
