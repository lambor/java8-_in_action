package ch03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by lambor on 17-4-28.
 */
public class Combination_3_8 {
    static class Apple {
        int weight;
        String country;

        public Apple(int weight, String country) {
            this.weight = weight;
            this.country = country;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "[apple] weight:"+ weight + " country:"+country;
        }
    }

    public static <T> List<T> filter(List<T> list,Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for(T item:list) {
            if(p.test(item))
                result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(120,"china"));
        apples.add(new Apple(100,"china"));
        apples.add(new Apple(123,"japan"));
        apples.add(new Apple(20,"france"));
        apples.add(new Apple(110,"usa"));
        apples.add(new Apple(120,"china"));
        apples.add(new Apple(30,"china"));
        apples.add(new Apple(20,"uk"));
        apples.add(new Apple(60,"china"));

        //比较器复合
        apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
        System.out.println(apples);

        //谓词复合
        Predicate<Apple> heavyApple = a->a.getWeight()>100;
        Predicate<Apple> notHeavyApple = heavyApple.negate();
        Predicate<Apple> heavyChinaApple = heavyApple.and(a->"china".equals(a.getCountry()));

        List<Apple> heavyApples = filter(apples,heavyApple);
        System.out.println("heavy apples:" + heavyApples);
        List<Apple> notHeavyApples = filter(apples,notHeavyApple);
        System.out.println("heavy apples:" + notHeavyApples);
        List<Apple> heavyChinaApples = filter(apples,heavyChinaApple);
        System.out.println("heavy apples:" + heavyChinaApples);

        //函数复合
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x*2;
        System.out.println("g(f(1))="+f.andThen(g).apply(1));
        System.out.println("f(g(2))="+f.compose(g).apply(2));
    }
}
