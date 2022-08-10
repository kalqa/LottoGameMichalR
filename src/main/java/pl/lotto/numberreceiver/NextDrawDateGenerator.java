package pl.lotto.numberreceiver;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;


public class NextDrawDateGenerator {


    public LocalDateTime generateNextDrawDate(LocalDateTime currentDate) {
        LocalDateTime now = currentDate;
        return now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
    }
}