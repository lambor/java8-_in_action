package ch12;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Created by lambor on 17-5-11.
 */
public class Duration_12_1 {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.of(13,20);
        LocalTime time2 = LocalTime.of(0,0);
        Duration d1 = Duration.between(time1,time2); //negative because end time is before start time
        Duration d2 = Duration.between(time2,time1);
        System.out.println(d1.toMinutes());
        System.out.println(d2.toMinutes());
    }
}
