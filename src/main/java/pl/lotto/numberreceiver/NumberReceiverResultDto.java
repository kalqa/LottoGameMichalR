package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

record NumberReceiverResultDto(Optional<UUID> clientLotteryId, Optional<LocalDateTime> drawDate) {
}


