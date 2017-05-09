package ch10;

import javax.smartcardio.Card;
import java.util.Optional;

/**
 * Created by lambor on 17-5-8.
 */
public class Optional_10_2 {

    public static class Insurance {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Car {
        private Optional<Insurance> insurance;

        public void setInsurance(Optional<Insurance> insurance) {
            this.insurance = insurance;
        }

        public Optional<Insurance> getInsurance() {
            return insurance;

        }
    }

    public static class Person {
        private Optional<Car> car;

        public void setCar(Optional<Car> car) {
            this.car = car;
        }

        public Optional<Car> getCar() {
            return car;
        }
    }

}
