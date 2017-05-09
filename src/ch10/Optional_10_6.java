package ch10;

import java.util.Optional;

/**
 * Created by lambor on 17-5-9.
 */
public class Optional_10_6 {
    public static Optional<BetterOptional_10_3_3.Insurance> nullSafeFindCheapestInsurance(Optional<BetterOptional_10_3_3.Person> person, Optional<BetterOptional_10_3_3.Car> car) {
        return person.flatMap(p->car.map(c->BetterOptional_10_3_3.findCheapestInsurance(p,c)));
    }

    public static void main(String[] args) {
        Optional<BetterOptional_10_3_3.Insurance> optInsurance = Optional.ofNullable(new BetterOptional_10_3_3.Insurance());
        optInsurance.filter(insurance ->
            "CambridgeInsurance".equals(insurance.getName())).ifPresent(x-> System.out.println("ok"));
    }

    public String getCarInsuranceName(Optional<BetterOptional_10_3_3.Person> person,int minAge) {
        return person.filter(p->p.getAge() >= minAge) //Optional<Person>
                .flatMap(BetterOptional_10_3_3.Person::getCar) //Optional<Car>
                .flatMap(BetterOptional_10_3_3.Car::getInsurance) //Optional<Insurance>
                .map(BetterOptional_10_3_3.Insurance::getName) //Optional<String>
                .orElse("Unknown"); //String
    }
}
