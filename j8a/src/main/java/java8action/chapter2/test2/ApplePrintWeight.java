package java8action.chapter2.test2;

public class ApplePrintWeight<T> implements ApplePredicate<T> {

    @Override
    public String accept(T apple) {
        Apple apple1 = (Apple) apple;
        return apple1.getWeight() > 1 ? "to weight" : "to light";
    }

}
