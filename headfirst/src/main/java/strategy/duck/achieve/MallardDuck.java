package strategy.duck.achieve;

import strategy.duck.Duck;
import strategy.duck.FlyRocketPowered;
import strategy.duck.behavior.impl.FlyWithWings;
import strategy.duck.behavior.impl.Quack;

/**
 * 鸭子的行为不是`继承`来的，而是和适当的行为对象`组合`来的
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        super.flyBehavior = new FlyWithWings();
        super.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real mallard duck");
    }

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        mallard.display();
        mallard.swim();
        mallard.setFlyBehavior(new FlyRocketPowered());
        mallard.performFly();
    }
}
