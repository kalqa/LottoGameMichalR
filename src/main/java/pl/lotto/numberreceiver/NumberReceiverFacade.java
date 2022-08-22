package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.*;

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
        if (!validate.isEverything()) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), validate.message);
        }
        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        LocalDateTime drawDateGenerated = generator.generateNextDrawDate(this.currentDate);
        Optional<LocalDateTime> drawDate = Optional.of(drawDateGenerated);

        UserInput userInput = new UserInput(clientLotteryId.get(), numbersFromUser);
        repository.save(userInput);
        return new NumberReceiverResultDto(clientLotteryId, drawDate, EVERYTHING_IS_OK.message);
    }
public Set<Integer> getNumbersForDay(){

        return null;
}
        ;

}
