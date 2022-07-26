package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NumberReceiverFacade {
    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        for (Integer number : numbersFromUser) {
            if (!isNumberInRange(number)) {
                return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "numbers out of range");
            }
        }
        if (numbersFromUser.isEmpty() ) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "you didn't provide numbers");
        }
        if (numbersFromUser.size() > 6) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "to many numbers");
        }
        if (numbersFromUser.size() < 6) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "too few numbers");
        }
        if (numbersFromUser.size() == 0) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "the numbers are not different");
        }

        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        Optional<LocalDateTime> drawDate = Optional.of(LocalDateTime.of(2022,7,30,12,0));
        return new NumberReceiverResultDto(clientLotteryId, drawDate, "everything is OK");
    }
    private boolean isNumberInRange(Integer number) {
        return number >= 1 && number < 100;
    }
}
