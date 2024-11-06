package model.services;

public class UsaInterestService implements InterestService {

    private final double interestRate;

    public UsaInterestService(final double interest) {
        this.interestRate = interest;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
