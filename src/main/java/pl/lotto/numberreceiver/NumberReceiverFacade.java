package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.*;

public class NumberReceiverFacade {
    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        for (Integer number : numbersFromUser) {
            if (!isNumberInRange(number)) {
                return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "numbers out of range");
            }
        }

        // kod do sprawdzenia poczatek

// set nie będzie zawierał powtarzalnych elementów. ułatwi to sptawe. Przekształć listę w set:
//            Set<Integer> expectedNumbersFromUser = new HashSet<>(numbersFromUser);

  //      public boolean contains(numbersFromUser Integer)

        Set<Integer> numbersFromUser1 = new HashSet<Integer>(numbersFromUser);
if (numbersFromUser.size()<6)
    return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "the numbers are not different");

//
//        for (Integer number : numbersFromUser) {
//            if(numbersFromUser.contains(numbersFromUser))  {
//                return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "the numbers are not different");
//            }
//        }
//
//        if (numbersFromUser.contains(numbersFromUser)) {
//            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "the numbers are not different");
//        }
// kod do sprawdzenia koniec



        if (numbersFromUser.isEmpty() ) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "you didn't provide numbers");
        }
        if (numbersFromUser.size() > 6) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "to many numbers");
        }
        if (numbersFromUser.size() < 6) {
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), "too few numbers");
        }


        Optional<UUID> clientLotteryId = Optional.of(UUID.randomUUID());
        Optional<LocalDateTime> drawDate = Optional.of(LocalDateTime.of(2022,7,30,12,0));


        return new NumberReceiverResultDto(clientLotteryId, drawDate, "everything is OK");
    }
    private boolean isNumberInRange(Integer number) {
        return number >= 1 && number < 100;
    }


}
