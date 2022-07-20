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
        if (numbersFromUser.size() > 6) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "to many numbers");
        }
        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        Optional<LocalDateTime> drawDate = Optional.of(LocalDateTime.now());
        return new NumberReceiverResultDto(clientLotteryId, drawDate, "everything is OK");
    }

    private boolean isNumberInRange(Integer number) {
        return number >= 1 && number < 100;
    }
}
