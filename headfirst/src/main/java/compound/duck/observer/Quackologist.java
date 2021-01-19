package compound.duck.observer;

/**
 * @author wy
 * @date 2020/11/19
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked");
    }
}
