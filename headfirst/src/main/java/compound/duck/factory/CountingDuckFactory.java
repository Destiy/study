package compound.duck.factory;

import compound.duck.*;
import compound.duck.decorate.QuackCounter;

/**
 * @author wy
 * @date 2020/11/19
 */
public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedhaedDuck() {
        return new QuackCounter(new RedhaedDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
