package ch11;

import java.util.concurrent.CompletableFuture;

/**
 * Created by lambor on 17-5-11.
 */
public class Completion11_5 {
    public static void main(String[] args) {
        CompletableFuture[] futures = Shop.findPricesStream("myPhone").map(future->future.thenAccept(System.out::println)).toArray(
                CompletableFuture[]::new
        );

        CompletableFuture.allOf(futures).join();

    }
}
