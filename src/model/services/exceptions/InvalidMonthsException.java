package model.services.exceptions;

public class InvalidMonthsException extends IllegalArgumentException {

    public InvalidMonthsException(String s) {
        super(s);
    }
}
