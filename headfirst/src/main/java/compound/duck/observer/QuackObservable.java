package compound.duck.observer;

/**
 * @author wy
 * @date 2020/11/19
 */
public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
