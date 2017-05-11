package ch12;

import ch11.Shop;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by lambor on 17-5-11.
 */
public class TimeZone_12_3 {
    public static void main(String[] args) {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        LocalDate date = LocalDate.of(2014, Month.MARCH,18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

        LocalDateTime dateTime = LocalDateTime.of(2014,Month.MARCH,18,13,45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        LocalDateTime dateTime2 = LocalDateTime.of(2014,Month.MARCH,18,13,45);
        Instant instantFromDateTime = dateTime2.toInstant(ZoneOffset.UTC);

        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant,romeZone);
    }
}
