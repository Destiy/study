package java8action.chapter7.parallelStream;

import java.util.stream.Stream;

/**
 * @author
 * @create 2020-04-08 22:12
 */
public class parallelDemo {

    // 并行流调用 sequential 方法转换为 顺序刘

    // 顺序流
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    // 并行流
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i +1)
                .limit(n)
                .parallel()     // TODO 转换为并行
                .reduce(0L, Long::sum);
    }
    public static void main(String[] args) {
        System.out.println(sequentialSum(10000));
    }
}
