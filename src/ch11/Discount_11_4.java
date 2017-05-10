package ch11;

import com.sun.org.apache.xpath.internal.operations.Quo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ch11.Shop.executor;

/**
 * Created by lambor on 17-5-10.
 */
public class Discount_11_4 {

    public static  <T> void test(Function<T,List<?>> f, T param) {
        long start = System.nanoTime();
        System.out.println(f.apply(param));
        long duration = (System.nanoTime() - start)/1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    public static List<String> findPrices(String product) {
        return Shop.shops.stream().map(shop->shop.getPriceStr(product)).map(Quote::parse).map(Discount::applyDiscount).collect(Collectors.toList());
    }

    public static List<String> findPrices2(String product) {
        List<CompletableFuture<String>> priceFutures = Shop.shops.stream()
                .map(shop->CompletableFuture.supplyAsync(()->shop.getPriceStr(product),executor))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote->CompletableFuture.supplyAsync(()->Discount.applyDiscount(quote),executor)))
                .collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        test(Discount_11_4::findPrices,"myPhone27S");
        test(Discount_11_4::findPrices2,"myPhone27S");
    }
}
