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
        return EVERYTHING_IS_OK;
    }
}
