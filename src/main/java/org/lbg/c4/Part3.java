package org.lbg.c4;

import java.util.Arrays;
import java.util.Scanner;

public class Part3 {

    // Function to calculate VAT
    public static double calculateVAT(double price, double vatRate) {
        return (price * vatRate) / 100;
    }

    // Function to handle the VAT calculation process
    public static void processVATCalculations(Scanner scanner) {
        System.out.print("Please enter the VAT rate: ");
        double vatRate = scanner.nextDouble();

        double[] prices = new double[10]; // Initial array size
        int count = 0;

        while (true) {
            System.out.print("Enter the product price (or type QUIT to finish): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("QUIT")) {
                break;
            }
            try {
                double price = Double.parseDouble(input);

                // Grow the array if necessary
                if (count == prices.length) {
                    prices = Arrays.copyOf(prices, prices.length * 2);
                }

                prices[count] = price;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price or type QUIT to finish.");
            }
        }

        // Sort the array
        double[] sortedPrices = Arrays.copyOf(prices, count);
        Arrays.sort(sortedPrices);

        // Print sorted prices
        System.out.println("Prices from lowest to highest:");
        for (double price : sortedPrices) {
            System.out.println("£" + price);
        }

        // Calculate and display total amount including VAT
        double totalAmount = 0.0;
        for (double price : sortedPrices) {
            double vatAmount = calculateVAT(price, vatRate);
            double totalPrice = price + vatAmount;
            totalAmount += totalPrice;
        }

        System.out.println("Total amount for all items including VAT: £" + totalAmount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Type QUIT to exit or press ENTER to continue: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("QUIT")) {
                break;
            }
            processVATCalculations(scanner);
        }

        scanner.close();
    }
}
