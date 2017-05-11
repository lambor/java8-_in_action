package ch12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;

/**
 * Created by lambor on 17-5-11.
 */
public class WithAttribute_12_2 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014,3,18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR,9);

        LocalDate date1_1 = LocalDate.of(2014,3,18);
        LocalDate date1_2 = date1_1.plusWeeks(1);
        LocalDate date1_3 = date1_2.minusYears(3);
        LocalDate date1_4 = date1_3.plus(6, ChronoUnit.MONTHS);
    }
}
