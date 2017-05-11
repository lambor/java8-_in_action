package ch12;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * Created by lambor on 17-5-11.
 */
public class TemporalAdjuster_12_2 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014,3,18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
    }
}
