package ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcnh on 17-4-25.
 */
public class Comparator_2_4 {
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
        apples.add(new Apple("blue",80));

        apples.sort((Apple a1,Apple a2)->{return a1.getWeight() - a2.getWeight();});
        for(Apple apple:apples) {
            System.out.println(apple.getWeight());
        }
    }
}
