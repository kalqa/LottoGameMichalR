package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public interface UserNumbersRepository {

    UserInput save(UserInput userInput);


    Map<UUID, DateAndNumber> findAllByTicketDate(LocalDateTime ticketDate);
}
