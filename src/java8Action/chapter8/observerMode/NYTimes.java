package java8Action.chapter8.observerMode;

/**
 * 观察者
 *
 * @author
 * @create 2020-04-12 23:48
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NT! " + tweet);
        }
    }
}
