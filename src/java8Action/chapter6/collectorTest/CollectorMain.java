package java8Action.chapter6.collectorTest;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author
 * @create 2020-04-08 21:25
 */
public class CollectorMain<A> {

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p ->candidate % p == 0);
    }

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, 100).boxed()
                .collect(new PrimeNumbersCollector());
        System.out.println(collect);
    }
}
