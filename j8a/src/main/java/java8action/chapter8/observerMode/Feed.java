package java8action.chapter8.observerMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2020-04-12 23:56
 */
public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new LeMonde());
        feed.registerObserver(new Guardian());
        feed.notifyObservers("wine Test queen said her favourite book is java 8 in Action!");
    }
}
