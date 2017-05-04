package ch06;

import ch04.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dcnh on 17-5-3.
 */
public class ReducingCollect_6_2 {
    public static void main(String[] args) {
        long howManyDishes = Dish.menu.stream().count();
        long howManyDishes2 = Dish.menu.stream().collect(Collectors.counting());

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

        int totalCalories = Dish.menu.stream()
                .filter(e->{System.out.println("filter:"+e);return true;})
                .collect(Collectors.summingInt(e-> {System.out.println("sum:"+e);return e.getCalories();}));


        double avgCalories = Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));

        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));

        String shortMenu2 = Dish.menu.stream().map(Dish::getName).collect(Collectors.reducing((a,b)->a+b)).get();

        String shortMenu3 = Dish.menu.stream().collect(Collectors.reducing("",Dish::getName,(s1,s2)->s1+s2));
    }
}
