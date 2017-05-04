package ch06;

import ch04.Dish;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by dcnh on 17-5-3.
 */
public class GroupCollect_6_3 {

    static enum CaloricLevel {
        DIET,NORMAL,FAT
    }

    public static void main(String[] args) {
        Map<Dish.Type,List<Dish>> dishesByType = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));

        Function<Dish,CaloricLevel> classifer = (Dish dish)-> {
            if(dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        };
        Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = Dish.menu.stream().collect(Collectors.groupingBy(classifer));

        Map<Dish.Type,Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel = Dish.menu.stream().collect(
                Collectors.groupingBy(Dish::getType,Collectors.groupingBy(classifer))
        );


        Map<Dish.Type,Long> typesCount = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));

        Map<Dish.Type,Optional<Dish>> mostCaloricByType = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                ));

        Map<Dish.Type,Dish> mostCaloricByType2 = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));

        Map<Dish.Type,Integer> totalCaloricByType = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.summingInt(Dish::getCalories)));

        Map<Dish.Type,Set<CaloricLevel>> caloricLevelByType = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.mapping(classifer,Collectors.toSet())));

    }
}
