package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by lambor on 17-4-27.
 *
 */
public class FunctionalInterface_3_4 {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T s : list) {
            if (p.test(s)) result.add(s);
        }
        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list)
            c.accept(i);
    }

    public static <T, R> List<R> parse(List<T> t, Function<T, R> f) {
        List<R> result = new ArrayList<R>();
        for (T s : t) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static <T> T sum(List<T> l, Sum<T> s) {
        return s.sum(l);
    }

    public interface Sum<T> {
        T sum(List<T> l);
    }

    public static boolean even(int i, IntPredicate ip) {
        return ip.test(i);
    }

    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        source.add("");
        source.add("12");
        source.add("");
        source.add("123");
        List<String> result = filter(source, (String s) -> !s.isEmpty());

        System.out.println("original string list:");
        forEach(source, System.out::println);
        System.out.println("result string list:");
        forEach(result, System.out::println);

        int sum = sum(
                parse(result, (String s) -> Integer.parseInt(s)),

                (List<Integer> ints) -> {
                    int res = 0;
                    for (Integer i : ints) {
                        res += i;
                    }
                    return res;
                }
        );
        System.out.println("sum:"+sum);

        System.out.println("sum is even? "+even(sum,(int i)->i%2==0));
    }
}
