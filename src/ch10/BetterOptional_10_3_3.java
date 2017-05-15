package ch10;

import scala.Option;

import java.util.Optional;

/**
 * Created by lambor on 17-5-9.
 */
public class BetterOptional_10_3_3 {
    //better version of Optional_10_2

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
        private Insurance insurance;

        public void setInsurance(Insurance insurance) {
            this.insurance = insurance;
        }

        public Optional<Insurance> getInsurance() {
            return Optional.ofNullable(insurance);

        }

        public Option<Insurance> getInsurance2() {
            return Option.apply(insurance);

        }
    }

    public static class Person {
        private Car car;

        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Optional<Car> getCar() {
            return Optional.ofNullable(car);
        }

        public Option<Car> getCar2() {
            return Option.apply(car);
        }
    }

    public static Insurance findCheapestInsurance(Person person,Car car) {
        return new Insurance();
    }

    public static void main(String[] args) {
        Optional<Person> optPerson = Optional.ofNullable(null);
        Optional<String> optName = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
    }
}
