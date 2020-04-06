package java8Action;

import java.util.function.Consumer;

public class ResponsibilityChain {

    public static void interrupt1(String s) {
        s = "aaaaa";
        System.out.println("interrupt1 = " + s);
    }

    public static void interrupt2(String s) {

        System.out.println("interrupt2 = " + s + " bbbbb");
    }

    public static void interrupt3(String s) {
        System.out.println("interrupt3");
    }

    public static void main(String[] args) {
        Consumer<String> interrupt1 = ResponsibilityChain::interrupt1;
        interrupt1.andThen(ResponsibilityChain::interrupt2)
                .andThen(ResponsibilityChain::interrupt3)
                .accept("fsdfsd");
    }
}
