package ch02;

import ch01.Stream_1_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcnh on 17-4-25.
 */
public class GenericPredicate_2_3 {
    public interface Predicate<T> {
        boolean test(T t);
    }
    
    public static <T> List<T> filter(List<T> list,Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for(T e:list) {
            if(p.test(e))result.add(e);
        }
        return result;
    }

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
    
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("blue",10));
        apples.add(new Apple("red",10));
        apples.add(new Apple("blue",200));
        apples.add(new Apple("green",100));

        List<Apple> redApples = filter(apples,(Apple apple)->"red".equals(apple.getColor()));
        for(Apple apple:redApples) {
            System.out.println(apple.getColor());
        }

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        List<Integer> evenNumbers = filter(nums,(Integer i)->i%2==0);
        for(Integer n:evenNumbers) {
            System.out.println(n);
        }
    }
}
