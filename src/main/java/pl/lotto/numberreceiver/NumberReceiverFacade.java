package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static pl.lotto.numberreceiver.NumberValidation.EVERYTHING_IS_OK;

public class NumberReceiverFacade {

    NumberValidator numberValidator;
    LocalDateTime currentDate;
    NextDrawDateGenerator generator;
    UserNumbersRepository repository;

    public NumberReceiverFacade(NumberValidator numberValidator, LocalDateTime currentDate, NextDrawDateGenerator generator, UserNumbersRepository repository) {
        this.numberValidator = numberValidator;
        this.currentDate = currentDate;
        this.generator = generator;
        this.repository = repository;

    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidation validate = numberValidator.validate(numbersFromUser);
        if (!validate.isEverythingOk()) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), validate.message);
        }
        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        LocalDateTime drawDateGenerated = generator.generateNextDrawDate(this.currentDate);
        Optional<LocalDateTime> drawDate = Optional.of(drawDateGenerated);

        UserInput userInput = new UserInput(clientLotteryId.get(), numbersFromUser, drawDateGenerated);
        repository.save(userInput);
        return new NumberReceiverResultDto(clientLotteryId, drawDate, EVERYTHING_IS_OK.message);
    }

    public Map<UUID, DateAndNumber> getNumbersForDay(LocalDateTime ticketDate) {
        return repository.findAllByTicketDate(ticketDate);
// ma zwrócić mape

    }

}
