package ch06;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lambor on 17-5-4.
 */
public class CustomPrimeCollector_6_6 {
    public static class PrimeNumbersCollector implements Collector<Integer,Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>> {

        public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
            int i=0;
            for(A item:list) {
                if(!p.test(item))
                    return list.subList(0,i);
                i++;
            }
            return list;
        }

        public static boolean isPrime(List<Integer> primes,int candidate) {
            int candidateRoot = (int) Math.sqrt((double)candidate);
            return takeWhile(primes,i->i<=candidateRoot).stream().noneMatch(p->candidate%p==0);
        }

        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return ()->new HashMap<Boolean,List<Integer>>() {
                //????
                {
                    put(true,new ArrayList<>());
                    put(false,new ArrayList<>());
                }
            };
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (map,i)->map.get(isPrime(map.get(true),i)).add(i);
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (map1,map2)->{
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
        }
    }

    public static void main(String[] args) {
        List<Integer> primes = IntStream.rangeClosed(2,100).boxed().collect(new PrimeNumbersCollector()).get(true);
        primes.forEach(i-> System.out.print(i+" "));


    }
}
