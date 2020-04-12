package java8Action.chapter8.observerMode;

/**
 * 观察者
 *
 * @author
 * @create 2020-04-12 23:52
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Breaking news in NT! " + tweet);
        }
    }
}
