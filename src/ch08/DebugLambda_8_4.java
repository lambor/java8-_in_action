package ch08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by lambor on 17-5-8.
 */
public class DebugLambda_8_4 {
    public static void main(String[] args) {
//        List<TestLambda_8_3.Point> points = Arrays.asList(new TestLambda_8_3.Point(12,2),null);
//        points.stream().map(TestLambda_8_3.Point::getX).forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(2,3,4);
//        numbers.stream().map(DebugLambda_8_4::divideByZero).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(2,3,4,5,6,7,8,9,10,11);
        numbers.stream().peek(x-> System.out.println("=============\nfrom stream: "+x))
                .map(x->x+17).peek(x-> System.out.println("after map: "+x))
                .filter(x->x%2==0).peek(x-> System.out.println("after filter: "+x))
                .limit(3).peek(x-> System.out.println("after limit: "+x))
                .forEach(System.out::println);
    }

    public static int divideByZero(int n) {
        return n/0;
    }
}
