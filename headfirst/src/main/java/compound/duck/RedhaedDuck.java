package compound.duck;

import compound.duck.observer.Observable;
import compound.duck.observer.Observer;

/**
 * @author wy
 * @date 2020/11/19
 */
public class RedhaedDuck implements Quackable {
    private Observable observable;

    public RedhaedDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("quack");
        this.notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
