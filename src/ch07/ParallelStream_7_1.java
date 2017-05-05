package ch07;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by dcnh on 17-5-4.
 */
public class ParallelStream_7_1 {
    public static long measureSumPref(Function<Long,Long> adder,long n) {
        long fastest = Long.MAX_VALUE;
        for(int i=0;i<10;i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result:"+sum+" duration:"+duration);
            if(duration < fastest)
                fastest = duration;
        }
        return fastest;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L,i->i+1).limit(n).reduce(0L,Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for(long i=1L;i<=n;i++) {
            result+=i;
        }
        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L,i->i+1).limit(n).parallel().reduce(0L,Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1,n).reduce(0L,Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1,n).parallel().reduce(0L,Long::sum);
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(0,n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
    public static class Accumulator {
        public long total = 0;
        public void add(long vaiue) {
            total += vaiue;
        }
    }

    public static void main(String[] args) {
//        System.out.println(measureSumPref(ParallelStream_7_1::sequentialSum,10_000_000));//236
//        System.out.println(measureSumPref(ParallelStream_7_1::iterativeSum,10_000_000));//6
//        System.out.println(measureSumPref(ParallelStream_7_1::parallelSum,10_000_000));//438
//        System.out.println(measureSumPref(ParallelStream_7_1::rangedSum,10_000_000));//7
//        System.out.println(measureSumPref(ParallelStream_7_1::parallelRangedSum,10_000_000));//4
        System.out.println(measureSumPref(ParallelStream_7_1::sideEffectParallelSum,10_000_000));//error
    }
}
