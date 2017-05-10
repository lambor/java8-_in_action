package ch11;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static ch11.Shop.shops;

/**
 * Created by lambor on 17-5-10.
 */
public class Shop_11_3 {

    //串行流
    public static List<String> findPrices(String product) {
        return shops.stream().map(shop->
            String.format("%s price is %.2f",shop.getName(),shop.getPrice(product))
        ).collect(Collectors.toList());
    }

    //并行流
    public static List<String> parallelFindPrices(String product) {
        return shops.stream().parallel().map(shop->
            String.format("%s price is %.2f",shop.getName(),shop.getPrice(product))
        ).collect(Collectors.toList());
    }


    //CompletableFuture
    public static List<String> futureFindPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream().map(
                shop->CompletableFuture.supplyAsync(
                        ()-> String.format("%s price is %.2f",shop.getName(),shop.getPrice(product))
                )
        ).collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start)/1_000_000;
        System.out.println("Done in "+duration+" msecs");

        start = System.nanoTime();
        System.out.println(parallelFindPrices("myPhone27S"));
        duration = (System.nanoTime() - start)/1_000_000;
        System.out.println("Done in "+duration+" msecs");

        start = System.nanoTime();
        System.out.println(futureFindPrices("myPhone27S"));
        duration = (System.nanoTime() - start)/1_000_000;
        System.out.println("Done in "+duration+" msecs");
    }
}
