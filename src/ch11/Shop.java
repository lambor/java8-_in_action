package ch11;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * Created by lambor on 17-5-10.
 */
public class Shop {

    public static List<Shop> shops = Arrays.asList(new Shop("BestPrice")
            , new Shop("LetsSaveBig")
            , new Shop("MyFavoriteShop")
            , new Shop("BuyItAll")
    );

    public static Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    private String name;
    private static Random random = new Random();

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop() {
        this("no name");
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPriceStr(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s",name,price,code);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void randomDelay() {
        int delay = random.nextInt(1000) + 500;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream().map(shop->CompletableFuture.supplyAsync(()->shop.getPriceStr(product),executor))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote->CompletableFuture.supplyAsync(()->Discount.applyDiscount(quote),executor)));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            double price = getPrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(()->getPrice(product));
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        long start  = System.nanoTime();
//        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        Future<Double> futurePrice = shop.getPriceAsync2("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        Stream.of(1,2,3,4,5).forEach(i->{
            System.out.println("browse the " + i + "th shop.");
            delay();
        });

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n",price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

}
