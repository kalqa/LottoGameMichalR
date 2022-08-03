package pl.lotto.numberreceiver;

public enum NumberValidation {

    YOU_DIDNT_PROVIDE_NUMBERS("you didn't provide numbers"),
    TOO_MANY_NUMBERS("to many numbers"),
    TOO_FEW_NUMBERS("too few numbers"),
    NUMBERS_OUT_OF_RANGE("numbers out of range"),
    THE_NUMBERS_ARE_DIFFERENT("the numbers are different"),
    EVERYTHING_IS_OK("everything is OK");


    String message;

    NumberValidation(String message) {
        this.message = message;
    }

    public boolean isEverything(){
        return this.equals(EVERYTHING_IS_OK);
    }

    NumberValidation() {
    }
}
