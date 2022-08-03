package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pl.lotto.numberreceiver.NumberValidation.EVERYTHING_IS_OK;

public class NumberReceiverFacade {

    NumberValidator numberValidator;
    LocalDateTime currentDate;

    NumberReceiverFacade(NumberValidator numberValidator, LocalDateTime currentDate) {
        this.numberValidator = numberValidator;
        this.currentDate = currentDate;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidation validate = numberValidator.validate(numbersFromUser);
        if (!validate.isEverything()) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), validate.message);
        }
        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        LocalDateTime drawDateGenerated = generateNextDrawDate();
        Optional<LocalDateTime> drawDate = Optional.of(drawDateGenerated);
        return new NumberReceiverResultDto(clientLotteryId, drawDate, EVERYTHING_IS_OK.message);
    }

    private LocalDateTime generateNextDrawDate() {
        LocalDateTime now = currentDate;
        return LocalDateTime.of(2022, 7, 30, 12, 0);
    }
}
