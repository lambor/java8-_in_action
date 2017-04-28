package ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by lambor on 17-4-28.
 */
public class ConstructRef_3_6 {
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

        @Override
        public String toString() {
            return "[apple] color:"+color+" weight:"+weight;
        }
    }

    public static List<Apple> map(List<String> colors, List<Integer> weights, BiFunction<String,Integer,Apple> f) {
        List<Apple> result = new ArrayList<>();
        int length = colors.size();
        for(int i=0;i<length;i++) {
            result.add(f.apply(colors.get(i),weights.get(i)));
        }
        return result;
    }

    //不能使用Function<T,Void>
    public static <T> void forEach(List<T> list, Consumer<T> f) {
        for(T t:list)
            f.accept(t);
    }

    public static void main(String[] args) {
        String[] colors_arr = {"green", "red", "blue"};
        List<String> colors = Arrays.asList(colors_arr);

        Integer[] weights_arr = {200, 100, 120};
        List<Integer> weights = Arrays.asList(weights_arr);

        List<Apple> apples = map(colors,weights,Apple::new);
        forEach(apples,System.out::println);
    }
}
