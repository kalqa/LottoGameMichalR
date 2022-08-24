package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

public class DateAndNumber {


    private final List<Integer> numbersFromUser;
    private final LocalDateTime drawDate;

    public DateAndNumber(List<Integer> numbersFromUser, LocalDateTime drawDate) {

        this.numbersFromUser = numbersFromUser;
        this.drawDate = drawDate;
    }
}
