package ch14;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by lambor on 17-5-12.
 */
public class Stream_14_3 {

    public static Stream<Integer> primes(int n) {
        return Stream.iterate(2,i->i+1).filter(Stream_14_3::isPrime).limit(5);
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2,candidateRoot)
                .noneMatch(i->candidate%i==0);
    }

    static IntStream numbers() {
        return IntStream.iterate(2,n->n+1);
    }

    static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

}
