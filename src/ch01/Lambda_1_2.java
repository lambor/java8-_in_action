package ch01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcnh on 17-4-25.
 */
public class Lambda_1_2 {
    static class Apple {
        String color;
        int weight;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
//    public static boolean isGreenApple(Apple apple) {
//        return "green".equals(apple.getColor());
//    }
//
//    public static boolean isHeavyWeight(Apple apple) {
//        return apple.getWeight() > 150;
//    }

    public interface Predicate<T> {
        boolean test(T t);
    }


    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory) {
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("blue",10));
        apples.add(new Apple("red",10));
        apples.add(new Apple("blue",200));
        apples.add(new Apple("green",100));

        List<Apple> greenApples = filterApples(apples, (Apple apple)->"green".equals(apple.color));
        for(Apple apple:greenApples) {
            System.out.println(apple.color);
        }

        List<Apple> heavyApples = filterApples(apples, (Apple apple)->apple.weight>150);
        for(Apple apple:heavyApples) {
            System.out.println(apple.weight);
        }
    }
}
