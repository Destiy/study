package java8action.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author
 * @create 2020-04-18 11:17
 */
public class Shop {

    Random random = new Random();

    private String name;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new  RuntimeException(e);
        }
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        // 异步计算
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                // 计算出结果，设置返回值
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        });
        return futurePrice;
    }

    /**
     * 等价于 getPriceAsync
     * @param product   商品
     * @return future
     */
    public Future<Double> getPriceAsyncFactory(String product) {
        return CompletableFuture.supplyAsync(() ->  calculatePrice(product));
    }
}
