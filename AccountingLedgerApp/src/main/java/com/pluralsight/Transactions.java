package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Transactions {
    static Scanner read = new Scanner(System.in);

    public static void makeDeposit() throws InterruptedException {
        double amount = 0;
        String description = "";
        String vendor = "";

        while (true) {
            System.out.println("Enter the amount to deposit:");
            System.out.print("> ");

            try {
                amount = read.nextDouble();
                if (amount <= 0) {
                    System.out.println("Deposit amount must be greater than zero.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                read.nextLine(); // Clear the invalid input
            }
        }

        read.nextLine();

        while(true) {
            System.out.println("Enter a description for the deposit:");
            System.out.print(">");
            description = read.nextLine().trim();
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty. Please enter a valid description.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter the vendor name for the deposit:");
            System.out.print(">");
            vendor = read.nextLine().trim();
            if (vendor.isEmpty()) {
                System.out.println("Vendor name cannot be empty. Please enter a valid vendor name.");
            } else {
                break;
            }
        }

        Menus.loadingBar();
        Ledger.writeToTransactionCsv(vendor, description, amount);
        System.out.println("--------------------------------------------------------");

    }

    public static void makePayment() throws InterruptedException {
        double amount = 0;
        String description = "";
        String vendor = "";

        while (true) {
            System.out.println("Enter the amount you wish to pay:");
            System.out.print("> ");

            try {
                amount = read.nextDouble();
                if (amount <= 0) {
                    System.out.println("Payment amount must be greater than zero.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                read.nextLine();
            }
        }

        read.nextLine();

        while(true) {
            System.out.println("Enter a description for the payment:");
            System.out.print(">");
            description = read.nextLine().trim();
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty. Please enter a valid description.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter the vendor name for the payment:");
            System.out.print(">");
            vendor = read.nextLine().trim();
            if (vendor.isEmpty()) {
                System.out.println("Vendor name cannot be empty. Please enter a valid vendor name.");
            } else {
                break;
            }
        }

        Menus.loadingBar();
        Ledger.writeToTransactionCsv(vendor, description, -amount);
        System.out.println("--------------------------------------------------------");
    }
}
