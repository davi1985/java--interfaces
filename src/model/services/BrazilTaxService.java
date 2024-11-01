package model.services;

public class BrazilTaxService implements TaxService {

    private static final double TAX_THRESHOLD = 100;

    public double tax(double amount) {
        TaxRate rate = amount <= TAX_THRESHOLD ? TaxRate.HIGH : TaxRate.LOW;

        return amount * rate.getRate();
    }

    private enum TaxRate {
        HIGH(0.2),
        LOW(0.15);

        private final double rate;

        TaxRate(double rate) {
            this.rate = rate;
        }

        public double getRate() {
            return rate;
        }
    }
}
