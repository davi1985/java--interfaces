package application;

import model.services.BrazilianInterestService;
import model.services.InterestService;
import model.services.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Months: ");
        int months = scanner.nextInt();

        InterestService brazilianInterestService = new BrazilianInterestService(2.0);
        double payment = brazilianInterestService.payment(amount, months);

        System.out.println();
        System.out.println("Payment after " + months + " months in BRL:");
        System.out.printf("$ %.2f%n", payment);

        InterestService usaInterestService = new UsaInterestService(1.0);
        payment = usaInterestService.payment(amount, months);

        System.out.println("Payment after " + months + " months in USA:");
        System.out.printf("$ %.2f%n", payment);
        scanner.close();
    }
}
