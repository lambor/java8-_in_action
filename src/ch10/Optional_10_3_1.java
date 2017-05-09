package ch10;

import java.util.Optional;

/**
 * Created by lambor on 17-5-8.
 */
public class Optional_10_3_1 {
    public static void main(String[] args) {
        Optional<Optional_10_2.Car> optCar = Optional.empty();

        Optional_10_2.Car car = null;
//        Optional<Optional_10_2.Car> optCar2 = Optional.of(car);

        Optional<Optional_10_2.Car> optCar3 = Optional.ofNullable(car);
    }
}
