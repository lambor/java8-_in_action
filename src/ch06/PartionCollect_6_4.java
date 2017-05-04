package ch06;

import ch04.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lambor on 17-5-4.
 */
public class PartionCollect_6_4 {
    public static void main(String[] args) {
        Map<Boolean,List<Dish>> vegetarianDishes = Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        List<Dish> vegetarianDishes1 = vegetarianDishes.get(true);
        //vs filter
        List<Dish> vegetarianDishes2 = Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        //vs groupingBy
        Map<Boolean,List<Dish>> vegetarianDishes3 = Dish.menu.stream().collect(Collectors.groupingBy(Dish::isVegetarian,Collectors.toList()));

        Map<Boolean,Map<Dish.Type,List<Dish>>> vegetarianDishesByType = Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian,
                Collectors.groupingBy(Dish::getType)));

        Map<Boolean,Dish> mostCaloricPartionedByVegaterian = Dish.menu.stream().collect(
                Collectors.partitioningBy(
                Dish::isVegetarian,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }

    public static boolean isPrime(int candidate) {
        return IntStream.range(2,candidate).noneMatch(i->candidate%i == 0);
    }

    public static boolean isPrime2(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2,candidateRoot).noneMatch(i->candidate%i == 0);
    }

    public Map<Boolean,List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2,n).boxed().collect(Collectors.partitioningBy(PartionCollect_6_4::isPrime2));
    }


}
