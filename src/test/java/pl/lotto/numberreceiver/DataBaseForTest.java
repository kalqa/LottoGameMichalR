package pl.lotto.numberreceiver;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataBaseForTest implements UserNumbersRepository {
    Map<UUID, DateAndNumber> database = new HashMap<>();

    @Override
    public UserInput save(UserInput userInput) {
        DateAndNumber dateAndNumber = new DateAndNumber(userInput.numbersFromUser, userInput.drawDate);
        database.put(userInput.lotteryId, dateAndNumber);
        return userInput;
    }
}
