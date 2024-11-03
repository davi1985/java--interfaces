package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private static final double MINUTES_IN_AN_HOUR = 60.0;
    private static final double MAX_HOURS_FOR_HOURLY_RATE = 12.0;
    private static final double HOURS_IN_A_DAY = 24.0;

    private final Double pricePerHour;
    private final Double pricePerDay;

    private final TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / MINUTES_IN_AN_HOUR;

        double basicPayment = calculateBasicPayment(hours);
        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    private double calculateBasicPayment(double hours) {
        return hours <= MAX_HOURS_FOR_HOURLY_RATE ? pricePerHour * Math.ceil(hours) :
                pricePerDay * Math.ceil(hours / HOURS_IN_A_DAY);
    }
}
