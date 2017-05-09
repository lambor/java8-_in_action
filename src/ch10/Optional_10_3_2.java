package ch10;

import java.util.Optional;

/**
 * Created by lambor on 17-5-8.
 */
public class Optional_10_3_2 {
    public static void main(String[] args) {
        Optional<Optional_10_2.Insurance> optInsurance = Optional.ofNullable(null);
        Optional<String> name = optInsurance.map(Optional_10_2.Insurance::getName);

        Optional<Optional_10_2.Person> optPerson = Optional.ofNullable(null);
        Optional<String> optName = optPerson.flatMap(Optional_10_2.Person::getCar).flatMap(Optional_10_2.Car::getInsurance).map(Optional_10_2.Insurance::getName);
    }
}
