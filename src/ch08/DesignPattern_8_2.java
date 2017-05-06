package ch08;

import ch04.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by lambor on 17-5-6.
 */
public class DesignPattern_8_2 {
    public interface ValidationStrategy {
        boolean execute(String s);
    }

    static class Validator {
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean validate(String s) {
            return strategy.execute(s);
        }
    }

    abstract static class Resturant {
        public void processDish(String name, Consumer<Dish> makeAppleCheap) {
            Dish.menu.stream().filter(name::equals).findFirst().ifPresent(makeAppleCheap);
        }

//        public void processDish(String name) {
//            Dish.menu.stream().filter(name::equals).findFirst().ifPresent(this::makeAppleCheap);
//        }
//        abstract void makeAppleCheap(Dish apple);
    }

    interface Observer {
        void notify(String tweet);
    }

    interface Subject {
        void registerObserver(Observer o);

        void notifyObservers(String tweet);
    }

    static class Feed implements Subject {

        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer o) {
            this.observers.add(o);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach(o -> o.notify(tweet));
        }
    }



    public static void main(String[] args) {
        //strategy pattern
        Validator lowerCaseValidator = new Validator((s) -> s.matches("[a-z]+"));
        boolean b1 = lowerCaseValidator.validate("aaaa");
        System.out.println(b1);
        Validator numericValidator = new Validator((s) -> s.matches("\\d+"));
        boolean b2 = numericValidator.validate("234");
        System.out.println(b2);

        //Template pattern
        new Resturant() {
        }.processDish("pizza", System.out::println);

        //Observer pattern
        Feed f = new Feed();
        f.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) System.out.println("Breaking news in NY! " + tweet);
        });
        f.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("queen"))
                System.out.println("Yet another news in London... " + tweet);
        });
        f.notifyObservers("The queen said she likes the book.");

        //Responsibility chains pattern
        UnaryOperator<String> headerProcess = text->"From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcess = text->text.replaceAll("labda","lambda");
        Function<String,String> pipeline = headerProcess.andThen(spellCheckerProcess);
        pipeline.apply("Aren't labdas really sexy?!!");

        //factory pattern
        //same as Fruits_3_6
    }
}
