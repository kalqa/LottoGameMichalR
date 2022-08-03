package pl.lotto.numberreceiver;

import java.util.List;
import java.util.Optional;

import static pl.lotto.numberreceiver.NumberValidation.*;

class NumberValidator {

    public NumberValidation validate(List<Integer> numbersFromUser) {
        if (numbersFromUser.isEmpty()) {
            return YOU_DIDNT_PROVIDE_NUMBERS;
        }
        if (numbersFromUser.size() > 6) {
            return TOO_MANY_NUMBERS;
        }
        if (numbersFromUser.size() < 6) {
            return TOO_FEW_NUMBERS;
        }
        long count = numbersFromUser.stream()
                .distinct()
                .count();
        if (count != 6) {
            return THE_NUMBERS_ARE_DIFFERENT;
        }
        for (Integer number : numbersFromUser) {
            if (!isNumberInRange(number)) {
                return NUMBERS_OUT_OF_RANGE;
            }
        }
        return EVERYTHING_IS_OK;
    }

    private boolean isNumberInRange(Integer number) {
        return number >= 1 && number < 100;
    }
}
