package ch05;

import ch04.Dish;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dcnh on 17-4-30.
 */
public class NumberStream_5_6 {
    public static void main(String[] args) {
        int calories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();

        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
//        Stream<Integer> integerStream = intStream.boxed();

        OptionalInt maxCalory = intStream.max();
        maxCalory.orElse(1);

        IntStream evenNumbers = IntStream.rangeClosed(1,100).filter(x->x%2==0);
        System.out.println(evenNumbers.count());

        //gou gu shu
        IntStream.rangeClosed(1,100).boxed()
                .flatMap(x->IntStream.rangeClosed(x,100).mapToObj(y->new double[]{x,y,Math.sqrt(x*x+y*y)}).filter(tri->tri[2]%1==0))
                .forEach(tri-> {
                    System.out.print("[");
                    Arrays.stream(tri).forEach(x-> System.out.print(x+" "));
                    System.out.println("]");
                });
    }
}
