package org.lbg.c4;

import java.util.Scanner;


public class Part1 {

    // Function to calculate VAT
    public static double calculateVAT(double price, double vatRate) {
        return (price * vatRate) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Use will enter the product price
        System.out.print("Enter the product price: ");
        double price = scanner.nextDouble();
        System.out.println("Please enter the VAT rate: ");
        double vat = scanner.nextDouble();

        // Setting the tax rate
        double vatRate = 20.0;

        // Calculating the VAT amount
        double vatAmount = calculateVAT(price, vatRate);

        // Calculate the total price including VAT
        double totalPrice = price + vatAmount;


        System.out.println("VAT amount: £" + vatAmount);
        System.out.println("Total price including VAT: £" + totalPrice);

        scanner.close();
    }
}