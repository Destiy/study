package java8action.chapter8.observerMode;

/**
 * @author
 * @create 2020-04-13 0:05
 */
public class ObserverLambda {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NT! " + tweet);
            }
        });

        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });

        feed.notifyObservers("wine Test queen said her favourite book is java 8 in Action!");
    }
}
