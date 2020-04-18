package java8action.chapter2.test2;

public class ApplePrintWeight2<T> implements ApplePredicate<T> {

    @Override
    public String accept(T t) {
        Apple apple = (Apple) t;
        return apple.getWeight() + "g";
    }
}
