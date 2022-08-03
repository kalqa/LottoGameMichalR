package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NumberReceiverFacade {

    NumberValidator numberValidator;

    NumberReceiverFacade(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidation validate = numberValidator.validate(numbersFromUser);
        if (!validate.equals(NumberValidation.EVERYTHING_IS_OK)) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), validate.message);
        }

        long count = numbersFromUser.stream()
                .distinct()
                .count();
// sprawdza jaka jest wielkość zbioru, dla nas powinna być 6

        if (count != 6) {
            String theNumbersAreNotDifferent = "the numbers are not different";
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), theNumbersAreNotDifferent);
        }

        for (Integer number : numbersFromUser) {
            if (!isNumberInRange(number)) {
                String numbers_out_of_range = "numbers out of range";
                return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), numbers_out_of_range);
            }
        }

        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        Optional<LocalDateTime> drawDate = Optional.of(LocalDateTime.of(2022, 7, 30, 12, 0));
        return new NumberReceiverResultDto(clientLotteryId, drawDate, "everything is OK");
    }

    private boolean isNumberInRange(Integer number) {
        return number >= 1 && number < 100;
    }


}
