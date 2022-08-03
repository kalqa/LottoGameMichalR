package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pl.lotto.numberreceiver.NumberValidation.EVERYTHING_IS_OK;

public class NumberReceiverFacade {
    NumberValidator numberValidator;

    NumberReceiverFacade(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidation validate = numberValidator.validate(numbersFromUser);
        if (!validate.isEverything()) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), validate.message);
        }
        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        Optional<LocalDateTime> drawDate = Optional.of(LocalDateTime.of(2022, 7, 30, 12, 0));
        return new NumberReceiverResultDto(clientLotteryId, drawDate, EVERYTHING_IS_OK.message);
    }
}
