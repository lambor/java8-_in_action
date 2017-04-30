package ch05;

import ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by dcnh on 17-4-29.
 */
public class FindMatch_5_3 {
    public static void main(String[] args) {
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendy!!");
        }

        boolean isHealthy = Dish.menu.stream().noneMatch(d->d.getCalories()>=1000);

        Optional<Dish> dish = Dish.menu.stream().filter(Dish::isVegetarian).findAny();

        Dish.menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d-> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x->x*x).filter(x->x%3==0).findFirst();
        firstSquareDivisibleByThree.ifPresent(System.out::println);
    }
}
