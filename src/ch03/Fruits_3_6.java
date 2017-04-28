package ch03;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by lambor on 17-4-28.
 */
public class Fruits_3_6 {
    interface Fruit {}

    static class Apple implements Fruit {}

    static class Orange implements Fruit {}

    static Map<String,Supplier<Fruit>> map = new HashMap<>();
    static {
        map.put("orange",Orange::new);
        map.put("apple",Apple::new);
    }

    public static Fruit giveMeFruit(String fruit) {
        return map.get(fruit).get();
    }

    public static void main(String[] args) {
        Apple apple = (Apple) giveMeFruit("apple");
        Orange orange = (Orange) giveMeFruit("orange");
    }
}
