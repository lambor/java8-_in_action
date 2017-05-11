package ch12;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * Created by lambor on 17-5-11.
 */
public class LocalDate_LocalTime_12_1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014,3,18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        //TemporalField interface
        LocalDate today = LocalDate.now();
        int thisyear = date.get(ChronoField.YEAR);
        int thismonth = date.get(ChronoField.MONTH_OF_YEAR);
        int thisday = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime time = LocalTime.of(13,45,20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDate date1 = LocalDate.parse("2014-03-18");
        LocalTime time1 = LocalTime.parse("13:45:20");

        LocalDateTime dt1 = LocalDateTime.of(2014,Month.MARCH,18,13,45,20);
        LocalDateTime dt2 = LocalDateTime.of(date,time);
        LocalDateTime dt3 = date1.atTime(time1);
        LocalDateTime dt4 = time1.atDate(date1);

        LocalDate date2 = dt1.toLocalDate();
        LocalTime time2 = dt1.toLocalTime();
    }
}
