package pl.lotto.numberreceiver;

public enum NumberValidation {

    YOU_DIDNT_PROVIDE_NUMBERS("you didn't provide numbers"),
    TOO_MANY_NUMBERS("to many numbers"),
    TOO_FEW_NUMBERS,
    THE_NUMBERS_ARE_DIFFERENT,
    THE_NUMBERS_ARE_DIFFERENT,
    EVERYTHING_IS_OK;

    String message;

    NumberValidation(String message) {
        this.message = message;
    }

    NumberValidation() {
    }
}
