package compound.duck.compound;

import compound.duck.Quackable;
import compound.duck.observer.Observer;

import java.util.ArrayList;

/**
 * @author wy
 * @date 2020/11/19
 */
public class Flock implements Quackable {
    ArrayList<Quackable> ducks = new ArrayList<>();

    public void add(Quackable quackable) {
        this.ducks.add(quackable);
    }

    @Override
    public void quack() {
        ducks.forEach(Quackable::quack);
    }

    @Override
    public void registerObserver(Observer observer) {
        ducks.forEach(duck -> duck.registerObserver(observer));
    }

    @Override
    public void notifyObservers() {

    }
}
