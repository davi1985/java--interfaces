package model.services.exceptions;

public class InvalidAmountException extends IllegalArgumentException {

    public InvalidAmountException(String s) {
        super(s);
    }
}
