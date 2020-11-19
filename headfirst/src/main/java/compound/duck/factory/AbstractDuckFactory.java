package compound.duck.factory;

import compound.duck.Quackable;

/**
 * @author wy
 * @date 2020/11/19
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedhaedDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
