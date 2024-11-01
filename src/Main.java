import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data:");
        System.out.print("Car model: ");
        String carModel = scanner.nextLine();

        System.out.print("Start (dd/MM/yyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

        System.out.print("Finish (dd/MM/yyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Price per hour: ");
        double pricePerHour = scanner.nextDouble();

        System.out.print("Price per day: ");
        double pricePerDay = scanner.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println();
        System.out.println("INVOICE: ");
        System.out.println("Base payment: $" + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: $" + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Total payment: $" + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

        scanner.close();
    }
}