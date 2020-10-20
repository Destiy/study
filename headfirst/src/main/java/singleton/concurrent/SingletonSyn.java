package singleton.concurrent;

/**
 * 效率低下
 */
public class SingletonSyn {
    private static SingletonSyn singletonSyn;

    private SingletonSyn() {

    }

    public static synchronized SingletonSyn getInstance() {
        if (singletonSyn == null) {
            singletonSyn = new SingletonSyn();
        }
        return singletonSyn;
    }
}
