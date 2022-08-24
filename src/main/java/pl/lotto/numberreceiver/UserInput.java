package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class UserInput {
    UUID lotteryId;
    List<Integer> numbersFromUser;
    LocalDateTime drawDate;

    public UserInput(UUID lotteryId, List<Integer> numbersFromUser, LocalDateTime drawDate) {
        this.lotteryId = lotteryId;
        this.numbersFromUser = numbersFromUser;
        this.drawDate = drawDate;
    }

}
