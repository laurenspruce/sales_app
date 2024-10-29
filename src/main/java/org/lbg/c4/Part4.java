package org.lbg.c4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Part4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the VAT rate: ");
            double vatRate = scanner.nextDouble();

            List<Double> prices = new ArrayList<>();

            while (true) {
                System.out.print("Enter the item price (or type QUIT to finish): ");
                String input = scanner.next();

                if (input.equalsIgnoreCase("QUIT")) {
                    break;
                }

                double price = Double.parseDouble(input);
                prices.add(price);
            }

            Collections.sort(prices);
            System.out.println("Sorted prices:");
            for (double price : prices) {
                System.out.println("£" + price);
            }

            double totalAmount = 0.0;
            for (double price : prices) {
                totalAmount += calculateTotalPrice(price, vatRate);
            }

            System.out.println("Total amount including VAT: £" + totalAmount);

            System.out.print("Type CONTINUE to calculate again or QUIT to exit: ");
            String decision = scanner.next();
            if (decision.equalsIgnoreCase("QUIT")) {
                break;
            }
        }

        scanner.close();
    }

    public static double calculateTotalPrice(double cost, double vatRate) {
        double vatAmount = (cost * vatRate) / 100;
        return cost + vatAmount;
    }
}

