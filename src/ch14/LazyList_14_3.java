package ch14;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Created by lambor on 17-5-12.
 */
public class LazyList_14_3 {
    interface MyList<T> {
        T head();

        MyList<T> tail();

        default boolean isEmpty() {
            return true;
        }

        default MyList<T> filter(Predicate<T> p) {
            return null;
        }

    }

    static class MyLinkedList<T> implements MyList<T> {

        private final T head;
        private final MyList<T> tail;

        public MyLinkedList(T head, MyList<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public MyList<T> tail() {
            return tail;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    static class Empty<T> implements MyList<T> {

        @Override
        public T head() {
            throw new UnsupportedOperationException();
        }

        @Override
        public MyList<T> tail() {
            throw new UnsupportedOperationException();
        }

    }

    static class MyLazyList<T> implements MyList<T> {

        private final T head;
        private final Supplier<MyList<T>> tail;

        public MyLazyList(T head, Supplier<MyList<T>> supplier) {
            this.head = head;
            this.tail = supplier;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public MyList<T> tail() {
            return tail.get();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public MyList<T> filter(Predicate<T> p) {
            return isEmpty() ?
                    this :
                    p.test(head()) ? new MyLazyList<>(head(), () -> tail().filter(p)) : tail().filter(p);
        }
    }

    public static MyLazyList<Integer> from(int n) {
        return new MyLazyList<Integer>(n, () -> from(n + 1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new MyLazyList<>(numbers.head(), () -> primes(
                numbers.tail().filter(n -> n % numbers.head() != 0)
        )
        );
    }

    public static <T> void printAll(MyList<T> list) {
        while(!list.isEmpty()) {
            System.out.println(list.head());
            list = list.tail();
        }
    }

    public static void main(String[] args) {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));

        MyLazyList<Integer> numbers = from(2);
        int two = primes(numbers).head();
        int three = primes(numbers).tail().head();
        int five = primes(numbers).tail().tail().head();

        System.out.println(""+two+","+three+","+five);
    }

}
