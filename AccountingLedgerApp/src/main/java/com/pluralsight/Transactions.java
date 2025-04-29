package com.pluralsight;

import java.util.Scanner;

public class Transactions {
    static Scanner read = new Scanner(System.in);

    public static void makeDeposit() {
        System.out.println("Enter the amount to deposit:");
        double amount = read.nextDouble();
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        read.nextLine();
        System.out.println("Enter a description for the deposit:");
        String description = read.nextLine();
        System.out.println("Enter the vendor name for the deposit:");
        String vendor = read.nextLine();

        Ledger.writeToTransactionCsv(vendor, description, amount);

    }

    public static void makePayment() {
        System.out.println("Enter the amount to pay:");
        double amount = read.nextDouble();
        if (amount <= 0) {
            System.out.println("Payment amount must be greater than zero.");
            return;
        }
        read.nextLine();
        System.out.println("Enter a description for the payment:");
        String description = read.nextLine();
        System.out.println("Enter the vendor name for the payment:");
        String vendor = read.nextLine();

        Ledger.writeToTransactionCsv(vendor, description, -amount);
    }
}
