package ch05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by dcnh on 17-4-29.
 */
public class Reduce_5_4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Integer product = numbers.stream().reduce(1,(a,b)->a*b);
        Integer sum = numbers.stream().reduce(0,(a,b)->a+b);
        Integer sum2= numbers.stream().reduce(0,Integer::sum);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("sum:"+sum);
        System.out.println("sum2:"+sum2);
        System.out.println("product:"+product);
        max.ifPresent(x-> System.out.println("max:"+x));
        min.ifPresent(y-> System.out.println("min:"+y));
        int count = numbers.stream().map(x->1).reduce(0,Integer::sum);
        System.out.println("count:"+count);
    }
}
