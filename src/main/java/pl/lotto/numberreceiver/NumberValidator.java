package pl.lotto.numberreceiver;

import java.util.List;
import java.util.Optional;
import static pl.lotto.numberreceiver.NumberValidation.EVERYTHING_IS_OK;
import static pl.lotto.numberreceiver.NumberValidation.TOO_MANY_NUMBERS;
import static pl.lotto.numberreceiver.NumberValidation.YOU_DIDNT_PROVIDE_NUMBERS;

class NumberValidator {

    public NumberValidation validate(List<Integer> numbersFromUser) {
        if (numbersFromUser.isEmpty()) {
            return YOU_DIDNT_PROVIDE_NUMBERS;
        }
        if (numbersFromUser.size() > 6) {
            return TOO_MANY_NUMBERS;
        }
        if (numbersFromUser.size() < 6) {
            String tooFewNumbers = "too few numbers";
            return new NumberReceiverResultDto(Optional.empty(), Optional.empty(), tooFewNumbers);
        }
        return EVERYTHING_IS_OK;
    }

}
