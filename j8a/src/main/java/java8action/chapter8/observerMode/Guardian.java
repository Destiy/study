package java8action.chapter8.observerMode;

/**
 * 观察者
 *
 * @author
 * @create 2020-04-12 23:51
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
