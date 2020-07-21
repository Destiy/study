package com.matree.threadLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @data 2020-07-21 23:44
 */
public class ThreadLocalTest {

    private List<String> messages = new ArrayList<>();
    public static final ThreadLocal<ThreadLocalTest> HOLDER =
            ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        HOLDER.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = HOLDER.get().messages;
        HOLDER.remove();
        System.out.println("size: " + HOLDER.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("一枝花算不算浪漫");
        System.out.println(HOLDER.get().messages);
        ThreadLocalTest.clear();
    }
}
