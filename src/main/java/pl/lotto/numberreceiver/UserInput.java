package pl.lotto.numberreceiver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class UserInput {
    UUID lotteryId;
    List<Integer> numbersFromUser;

    public UserInput(UUID lotteryId, List<Integer> numbersFromUser) {
        this.lotteryId = lotteryId;
        this.numbersFromUser = numbersFromUser;
    }
}
