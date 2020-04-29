package com.matree.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * JKD6 以前版本在HotSpot 虚拟机中，常量池分配在永久代中
 * 可以通过 -XX:PermSize 和 -XX:MaxPermSize 限制大小
 *
 * JDK7 -XX:MaxPermSize 或8 -XX:MaxMetaspaceSize=10M 以上版本，常量池移到Java堆，限制方法区没有意义，会无线循环。
 * 限制其堆大小-Xmx 就能看到错误
 * intern() https://www.runoob.com/java/java-string-intern.html 评论
 * @author wy
 * @create 2020-04-28 10:56 PM
 */
public class RuntimeConstantPoolOOM {

    public static void oom(){
        // 使用Set 保持着常量池引用，避免Full GC 回收常量池行为
        Set<String> set = new HashSet<>();

        short i = 0;
        while(true){

            // intern 方法，如果常量池中已经包含一个等于此String 对象的字符串
            // 则返回代表池中这个字符串的String 的引用；反之则加入到到常量池
            set.add(String.valueOf(i++).intern());
        }
    }

    /**
     * 因为constant pool跟interned string pool是两个不同的东西。
     */
    private static void intern() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern() == str2);
    }
    public static void main(String[] args) {
//        oom();
        intern();

    }
}
