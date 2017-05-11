package ch12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

/**
 * Created by lambor on 17-5-11.
 */
public class NextWorkingDat implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if(dow == DayOfWeek.FRIDAY) dayToAdd = 3;
        else if(dow == DayOfWeek.SATURDAY) dayToAdd = 2;
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }

    public static void main(String[] args) {
        LocalDate nextWorkDate = LocalDate.now().with(new NextWorkingDat());
        LocalDate nextWorkDate2 = LocalDate.now().with(TemporalAdjusters.ofDateAdjuster((temporal)->{
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if(dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            else if(dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }));
    }
}
