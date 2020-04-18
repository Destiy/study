package java8action.chapter5.trans;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransMain {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 找出2011年发生的所有交易，并按交易额排序(从低到高)
        List<Transaction> collect = transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(collect);

        // 2. 交易员都在哪些不同的城市工作过
        List<Trader> traders = Arrays.asList(
                raoul,
                mario,
                alan,
                brian
        );
        List<String> collect1 = traders.stream()
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);

        // 3. 查找所有来自于剑桥的交易员，并按姓名排序
        List<Transaction> cambridge = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(x -> x.getTrader().getName()))
                .collect(Collectors.toList());
        System.out.println(cambridge);

        // 4. 返回所有交易员的姓名字符串，按字母顺序排序
        String reduce = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
//                .reduce("", (x, y) -> x + " " +  y);    // 效率不高
                .collect(Collectors.joining()); // 代替方案 使用StringBuilder
        System.out.println(reduce);

        // 5. 有没有交易员是在米兰工作的
        boolean milan = transactions.stream()
                .anyMatch(x -> x.getTrader().getCity().equals("Milan"));
//        List<Transaction> milan1 = transactions.stream()
//                .filter(x -> x.getTrader().getCity().equals("Milan"))
//                .collect(Collectors.toList());
//        System.out.println(milan1);
        System.out.println(milan);

        // 6. 打印生活在剑桥的交易员的所有交易额
        List<Integer> cambridge1 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println(cambridge1);

        // 7. 所有交易种，最高交易额是多少
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);

        // 8. 找到最小交易额的交易
        transactions.stream()
                .reduce((x, y) -> x.getValue() > y.getValue() ? y : x)
                .ifPresent(System.out::println);
        // 或者
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}
