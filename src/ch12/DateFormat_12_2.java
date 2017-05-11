package ch12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by lambor on 17-5-11.
 */
public class DateFormat_12_2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014,2,18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);

        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMM yyyy", Locale.ITALY);
        LocalDate date1 = LocalDate.of(2014,3,18);
        String formattedDate = date1.format(italianFormatter);
        System.out.println(formattedDate);
        LocalDate date2 = LocalDate.parse(formattedDate,italianFormatter);
    }
}
