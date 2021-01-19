package singleton.concurrent;

/**
 * 饿汉创建
 */
public class SingletonInit {
    private static final SingletonInit singletonInit = new SingletonInit();

    private SingletonInit() {
    }

    public static SingletonInit singletonInit() {
        return singletonInit;
    }
}
