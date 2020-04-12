package java8Action.chapter8.observerMode;

/**
 * @author
 * @create 2020-04-12 23:55
 */
public interface Subject {
    // 注册观察者
    void registerObserver(Observer o);
    // 通知观察者
    void notifyObservers(String tweet);
}
