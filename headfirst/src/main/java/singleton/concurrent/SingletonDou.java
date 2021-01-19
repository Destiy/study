package singleton.concurrent;

/**
 * 双重锁校验
 * TODO 对1.4 以前版本无效
 */
public class SingletonDou {

    private volatile static SingletonDou singletonDou;

    private SingletonDou() {
    }

    private static SingletonDou getInstance() {
        if (singletonDou == null) {
            synchronized (SingletonDou.class) {
                if (singletonDou == null) {
                    singletonDou = new SingletonDou();
                }
            }
        }
        return singletonDou;
    }
}
