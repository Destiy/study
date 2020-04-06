package java8Action.chapter2.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 修改为泛型
 *
 * @param <T>
 */
public class AppleMain<T> {

    public void prettyPrintApple(List<T> inventory, ApplePredicate<T> p) {
//        List<> list = new ArrayList<>();
        for (T apple : inventory) {
            String accept = p.accept(apple);
            System.out.println(accept);
        }
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(Apple.builder().color("red").weight(1).build());
        inventory.add(Apple.builder().color("yellow").weight(5).build());

        AppleMain<Apple> appleAppleMain = new AppleMain<>();
        appleAppleMain.prettyPrintApple(inventory, new ApplePrintWeight<Apple>());
        appleAppleMain.prettyPrintApple(inventory, new ApplePrintWeight2<Apple>());
        // TODO lambda
        appleAppleMain.prettyPrintApple(inventory, (Apple apple) -> apple.getWeight() + "g");
    }
}
