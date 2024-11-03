package model.services;

public interface OnlineContractService {
    double paymentFee(double amount);

    double interest(double amount, int months);
}
