package ch07;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by dcnh on 17-5-4.
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinSumCalculator left = new ForkJoinSumCalculator(numbers,start,start+length/2);
        left.fork();

        ForkJoinSumCalculator right = new ForkJoinSumCalculator(numbers,start+length/2,end);

        long rightResult = right.compute();
        long leftResult = left.join();

        return leftResult+rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for(int i=start;i<end;i++) {
            sum += numbers[i];
        }
        return  sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }


    public static void main(String[] args) {
        System.out.println(ParallelStream_7_1.measureSumPref(ForkJoinSumCalculator::forkJoinSum,10_000_000));//50

    }
}
