package org.lbg.c4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Item {
    private double price;
    private int quantity;

    public Item(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice(double vatRate) {
        double vatAmount = (price * vatRate) / 100;
        return (price + vatAmount) * quantity;
    }

    public double getPrice() {
        return price;
    }
}

public class Part5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the VAT rate: ");
            double vatRate = scanner.nextDouble();

            List<Item> items = new ArrayList<>();

            while (true) {
                System.out.print("Enter the item price (or type QUIT to finish): ");
                String input = scanner.next();

                if (input.equalsIgnoreCase("QUIT")) {
                    break;
                }

                double price = Double.parseDouble(input);
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                items.add(new Item(price, quantity));
            }

            Collections.sort(items, (a, b) -> Double.compare(a.getPrice(), b.getPrice()));
            System.out.println("Sorted prices:");
            for (Item item : items) {
                System.out.println("£" + item.getPrice());
            }

            double totalAmount = 0.0;
            for (Item item : items) {
                double itemTotal = item.getTotalPrice(vatRate);
                totalAmount += itemTotal;
                System.out.println("Total for this item: £" + itemTotal);
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
}

