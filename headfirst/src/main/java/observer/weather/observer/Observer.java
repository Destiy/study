package observer.weather.observer;

public interface Observer {

    /**
     * 当天气发生改变，会调用这个方法，通知所有观察者
     * @param temp      温度
     * @param humidity  湿度
     * @param pressure  压力
     */
    void update(float temp, float humidity, float pressure);
}
