package model.services;

import model.services.exceptions.InvalidAmountException;
import model.services.exceptions.InvalidMonthsException;

public interface InterestService {

    double BASE_INTEREST_MULTIPLIER = 1.0;
    double PERCENTAGE_DIVISOR = 100.0;
    int MINIMUM_MONTHS = 1;

    double getInterestRate();

    default double payment(final double amount, final int months) {
        validateAmountAndMonths(amount, months);

        return amount * Math.pow(BASE_INTEREST_MULTIPLIER + getInterestRate() / PERCENTAGE_DIVISOR, months);
    }

    private static void validateAmountAndMonths(final double amount, final int months) {
        if (months < MINIMUM_MONTHS) {
            throw new InvalidMonthsException("Months must be grater than zero");
        }

        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
    }
}
