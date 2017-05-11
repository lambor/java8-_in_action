package ch12;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by lambor on 17-5-11.
 */
public class Period_12_1 {
    public static void main(String[] args) {
        Period tenDays = Period.between(LocalDate.of(2014,3,8),LocalDate.of(2014,3,18));
        System.out.println(tenDays.toString());
    }
}
