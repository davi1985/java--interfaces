package model.services;

public class BrazilianInterestService implements InterestService {

    private final double interestRate;

    public BrazilianInterestService(final double interest) {
        this.interestRate = interest;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
