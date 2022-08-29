package pl.lotto.numberreceiver;


import java.time.LocalDateTime;
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

    @Override
    public Map<UUID, DateAndNumber> findAllByTicketDate(LocalDateTime ticketDate) {
        return null;
//        database.get(ticketDate);
//        return ticketDate;
    }
}
