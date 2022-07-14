package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NumberReceiverFacade {
    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        Optional<LocalDateTime> drawDate = Optional.of(LocalDateTime.now());
        return new NumberReceiverResultDto(clientLotteryId, drawDate, "wszystko ok");
    }
}
