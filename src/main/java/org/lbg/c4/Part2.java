package org.lbg.c4;

import java.util.Scanner;

/*Allows user to enter a VAT Rate followed by series of item prices and calculates the total.
this should be completed in a function. after total amount has been displayed, the user should be
prompted to continue with more calculations, or QUIT by typing QUIT
When the app starts it should prompt the user to QUIT by typing QUIT or PRESS ENTER to continue entering prices.*/

public class Part2 {

    // Function to calculate VAT
    public double calculateVAT(double price, double vatRate) {
        return (price * vatRate) / 100;
    }

    // Function to handle the VAT calculation process
    public void processVATCalculations(Scanner scanner) {
        System.out.print("Please enter the VAT rate: ");
        double vatRate = scanner.nextDouble();

        double totalAmount = 0.0;
        while (true) {
            System.out.print("Enter the product price (or type QUIT to finish): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("QUIT")) {
                break;
            }
            double price = Double.parseDouble(input);
            double vatAmount = calculateVAT(price, vatRate);
            double totalPrice = price + vatAmount;
            totalAmount += totalPrice;

            System.out.println("VAT amount: £" + vatAmount);
            System.out.println("Total price including VAT: £" + totalPrice);
        }

        System.out.println("Total amount for all items: £" + totalAmount);
    }

    public void processInput() {
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
    public static void main(String[] args) {
        Part2 p2 = new Part2();
        p2.processInput();
    }
}
