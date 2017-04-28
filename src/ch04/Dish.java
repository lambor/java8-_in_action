package ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lambor on 17-4-28.
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {MEAT,FISH,OTHER};

    public static final List<Dish> menu = Arrays.asList(
            new Dish("pork",false,800, Type.MEAT),
            new Dish("beef",false,700, Type.MEAT),
            new Dish("chicken",false,400, Type.MEAT),
            new Dish("french",true,530, Type.OTHER),
            new Dish("rice",true,350, Type.OTHER),
            new Dish("season fruit",true,120, Type.OTHER),
            new Dish("pizza",true,550, Type.MEAT),
            new Dish("prawns",false,300, Type.MEAT),
            new Dish("salmon",false,450, Type.MEAT)
    );

    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = menu.stream().filter(x->x.getCalories()>300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);

        Stream<String> stream = menu.stream().map(Dish::getName);
        stream.forEach(System.out::println);
        try {
            stream.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("======================================");

        List<String> names = menu.stream().filter(d -> {
            System.out.println("filtering " + d.getName());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("mapping " + d.getName());
            return d.getName();
        }).limit(2).collect(Collectors.toList());
        System.out.println(names);
    }
}
