package java8action.chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author wy
 * @date  2020-04-18 11:21
 */
public class ShopMain {

    private List<Shop> shops = Arrays.asList(new Shop("BestPrice")
            , new Shop("LetsSaveBig")
            , new Shop("MyFavoritesSho")
            , new Shop("BuyItAll")
    );

    /**
     * N threads = N cpu  + U cpu * (1 + W/C)
     * 创建线程池
     *
     */
    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread thread = new Thread(r);
        // 使用守护线程-这种方式不会阻止程序的关停
        thread.setDaemon(true);
        return thread;
    });

    /**
     * 异步api
     */
    public static void test1() {
        Shop baseShop = new Shop();
        long start = System.nanoTime();
        Future<Double> futurePrice = baseShop.getPriceAsyncFactory("my favorite product");
        long time = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + time + " msecs");

        try {
            // 从Future 对象中读取结果，如果结果未知，会发生阻塞
            Double price = futurePrice.get();
            System.out.printf("price is %.2f%n", price);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("price returned after " + retrievalTime + "mescs");
    }
//    -------------------------------------------------------------------------------------------

    /**
     * 顺序查询 4ms
     */
    private List<String> findPrices(String product) {
        return shops.stream().map(shop -> String.format("%s price is %.2f,", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 并行操作 1ms
     *
     * @param product 商品名
     * @return price
     */
    private List<String> findPricesParallel(String product) {
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f,", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    private void testStreamPrice() {
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27s"));
        long time = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + time + "msecs");

        System.out.println("---------------------------");
        // 并行
        start = System.nanoTime();
        System.out.println(findPricesParallel("myPhone27s"));
        time = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + time + "msecs");

        System.out.println("---------------------------");
        // future
        start = System.nanoTime();
        System.out.println(completableFutureFindPrices("myPhone27s"));
        time = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + time + "msecs");

        System.out.println("---------------------------");
        // future 定制线程池
        start = System.nanoTime();
        System.out.println(completableFutureExecutorFindPrices("myPhone27s"));
        time = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + time + "msecs");
    }
//    -------------------------------------------------------------------------------------------

    /**
     * 使用CompletableFuture 实现findPrices 2ms
     *
     * @param product 价格
     */
    private List<String> completableFutureFindPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> shop.getName() + "price is " + shop.getPrice(product)
        )).collect(Collectors.toList());

        // 使用第二个流，因为返回为List<String>
        // 如果在一个流需要等待Future 执行完毕后才能将包含的值取出来
        return priceFutures.stream()
                .map(CompletableFuture::join)   // 等待所有一步操作结束
                .collect(Collectors.toList());
    }

    /**
     * 使用CompletableFuture 定制Executor 实现findPrices 2ms
     *
     * @param product 价格
     */
    private List<String> completableFutureExecutorFindPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> shop.getName() + "price is " + shop.getPrice(product), executor
        )).collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ShopMain shopMain = new ShopMain();
//        test1();
        shopMain.testStreamPrice();


    }
}
