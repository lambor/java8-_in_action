package ch05;

import ch04.Dish;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dcnh on 17-4-29.
 */
public class StreamBasic_5_1 {
    public static void main(String[] args) {
        List<Dish> vegetarianMenu =  Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(i->i%2==0)
                .distinct()
                .forEach(System.out::println);

        List<Dish> dishes = Dish.menu.stream().filter(d->d.getCalories()>300).limit(3)
                .skip(2)
                .collect(Collectors.toList());

        List<String> dishNames = Dish.menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Java8","Lambdas","In","Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(wordLengths);

        List<Integer> dishNameLengths = Dish.menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(dishNameLengths);

        words.stream().map(s->s.split("")).flatMap(Arrays::stream).collect(Collectors.toList());

        List<Integer> squares = numbers.stream().map(x->x*x).collect(Collectors.toList());

        List<Integer> xs = Arrays.asList(1,2,3);
        List<Integer> ys = Arrays.asList(4,5);
        List<int[]> result = xs.stream().flatMap(x->ys.stream().map(y->new int[]{x,y})).filter(xy->(xy[0]+xy[1])%3==0).collect(Collectors.toList());
        result.forEach(i->{
            System.out.print("[");
            Arrays.stream(i).forEach(System.out::print);
            System.out.println("]");
        });
    }
}
