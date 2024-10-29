package org.lbg.c4;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    // Function to calculate VAT
    public static double calculateVAT(double price, double vatRate) {
        return (price * vatRate) / 100;
    }

    // Function to handle the VAT calculation process
    public static void processVATCalculations(Scanner scanner) {
        Prompt prompt = new Prompt(scanner);
        double vatRate = prompt.getDouble("Please enter the VAT rate: ");

        double[] prices = new double[10]; // Initial array size
        int count = 0;

        while (true) {
            String input = prompt.getString("Enter the product price (or type QUIT to finish): ");
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
        Runner runner = new Runner(scanner);
        runner.run();  // Start the runner
        scanner.close();
    }
}

class Prompt {
    private final Scanner scanner;

    public Prompt(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public double getDouble(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print(message);
            }
        }
    }
}

// Runner class to manage the execution flow
class Runner {
    private final Scanner scanner;
    private final Prompt prompt;

    public Runner(Scanner scanner) {
        this.scanner = scanner;
        this.prompt = new Prompt(scanner);
    }

    public void run() {
        while (true) {
            String input = prompt.getString("Type QUIT to exit or press ENTER to continue: ");
            if (input.equalsIgnoreCase("QUIT")) {
                break;
            }
            Part3.processVATCalculations(scanner);
        }
    }
}
