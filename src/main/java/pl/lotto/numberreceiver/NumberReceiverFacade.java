package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.*;

import static pl.lotto.numberreceiver.NumberValidation.EVERYTHING_IS_OK;

public class NumberReceiverFacade {

    NumberValidator numberValidator;
    LocalDateTime currentDate;
    NextDrawDateGenerator generator;
    Map<UUID, List<Integer>> dataBase = new HashMap<>();

    public NumberReceiverFacade(NumberValidator numberValidator, LocalDateTime currentDate, NextDrawDateGenerator generator) {
        this.numberValidator = numberValidator;
        this.currentDate = currentDate;
        this.generator = generator;

    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidation validate = numberValidator.validate(numbersFromUser);
        if (!validate.isEverything()) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), validate.message);
        }
        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        LocalDateTime drawDateGenerated = generator.generateNextDrawDate(this.currentDate);
        Optional<LocalDateTime> drawDate = Optional.of(drawDateGenerated);

        dataBase.put(clientLotteryId.get(), numbersFromUser);

        return new NumberReceiverResultDto(clientLotteryId, drawDate, EVERYTHING_IS_OK.message);
    }


}
