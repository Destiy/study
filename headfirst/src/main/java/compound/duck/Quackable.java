package compound.duck;

import compound.duck.observer.QuackObservable;

/**
 * @author wy
 * @date 2020/11/19
 */
public interface Quackable extends QuackObservable {
    public void quack();
}
