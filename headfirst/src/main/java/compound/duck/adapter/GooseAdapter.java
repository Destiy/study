package compound.duck.adapter;

import compound.duck.Quackable;
import compound.duck.observer.Observable;
import compound.duck.observer.Observer;

/**
 * @author wy
 * @date 2020/11/19
 */
public class GooseAdapter implements Quackable {
    private final Goose goose;
    private final Observable observable;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
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
