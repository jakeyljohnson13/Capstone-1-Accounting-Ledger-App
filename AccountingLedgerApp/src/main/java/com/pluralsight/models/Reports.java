package com.pluralsight.models;

import java.time.LocalDate;
import java.util.Scanner;

public class Reports {
    static Scanner read = new Scanner(System.in);
    public static void monthToDateTransactionReport() {
        System.out.println("Month-to-Date Transaction Report");
        System.out.println("--------------------------------------------------------");

        // Get the current date
        LocalDate today = LocalDate.now();
        // Get the first day of the current month by setting the day of the month to 1
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the month and not after today, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfMonth) && !ledger.getTransactionDate().isAfter(today)) {
                LedgerService.printLedger(ledger);
                totalAmount += ledger.getAmount();
                hasTransactions = true;
            }
        }

        // if there's no transactions, print a message, otherwise print the total amount
        if (!hasTransactions) {
            System.out.println("No transactions found for the current month.");
        } else {
            System.out.printf("Total Amount: %.2f%n", totalAmount);
        }
        System.out.println("--------------------------------------------------------");
    }


    public static void previousMonthTransactionReport() {
        System.out.println("Previous Month Transaction Report");
        System.out.println("--------------------------------------------------------");


        LocalDate today = LocalDate.now();

        LocalDate firstDayOfCurrentMonth = today.withDayOfMonth(1);
        // Get the first day of the previous month by subtracting one month from the first day of the current month
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
        // Get the last day of the previous month by subtracting one day from the first day of the current month
        LocalDate lastDayOfPreviousMonth = firstDayOfCurrentMonth.minusDays(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the previous month and not after the last day of the previous month, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfPreviousMonth) && !ledger.getTransactionDate().isAfter(lastDayOfPreviousMonth)) {
                LedgerService.printLedger(ledger);
                totalAmount += ledger.getAmount();
                hasTransactions = true;
            }
        }

        if (!hasTransactions) {
            System.out.println("No transactions found for the previous month.");
        } else {
            System.out.printf("Total Amount: %.2f%n", totalAmount);
        }
        System.out.println("--------------------------------------------------------");
    }


    public static void yearToDateTransactionReport() {
        System.out.println("Year-to-Date Transaction Report");
        System.out.println("--------------------------------------------------------");

        LocalDate today = LocalDate.now();
        // Get the first day of the current year by setting the day of the year to 1
        LocalDate firstDayOfYear = today.withDayOfYear(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the year and not after today, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfYear) && !ledger.getTransactionDate().isAfter(today)) {
                LedgerService.printLedger(ledger);
                totalAmount += ledger.getAmount();
                hasTransactions = true;
            }
        }

        if (!hasTransactions) {
            System.out.println("No transactions found for the current year.");
        } else {
            System.out.printf("Total Amount: %.2f%n", totalAmount);
        }
        System.out.println("--------------------------------------------------------");
    }


    public static void previousYearTransactionReport() {
        System.out.println("Previous Year Transaction Report");
        System.out.println("--------------------------------------------------------");

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrentYear = today.withDayOfYear(1);
        // Get the first day of the previous year by subtracting one year from the first day of the current year
        LocalDate firstDayOfPreviousYear = firstDayOfCurrentYear.minusYears(1);
        // Get the last day of the previous year by subtracting one day from the first day of the current year
        LocalDate lastDayOfPreviousYear = firstDayOfCurrentYear.minusDays(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the previous year and not after the last day of the previous year, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfPreviousYear) && !ledger.getTransactionDate().isAfter(lastDayOfPreviousYear)) {
                LedgerService.printLedger(ledger);
                totalAmount += ledger.getAmount();
                hasTransactions = true;
            }
        }

        if (!hasTransactions) {
            System.out.println("No transactions found for the previous year.");
        } else {
            System.out.printf("Total Amount: %.2f%n", totalAmount);
        }
        System.out.println("--------------------------------------------------------");
    }


    public static void searchByVendorReport() {
        System.out.println("Search by Vendor Transaction Report");
        System.out.println("--------------------------------------------------------");


        System.out.print("Enter the vendor name to search for: ");
        String vendorName = read.nextLine().trim();

        if (vendorName.isEmpty()) {
            System.out.println("Vendor name cannot be empty.");
            System.out.println("--------------------------------------------------------");
            return;
        }

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that matches the vendor name, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (ledger.getVendor().equalsIgnoreCase(vendorName)) {
                LedgerService.printLedger(ledger);
                totalAmount += ledger.getAmount();
                hasTransactions = true;
            }
        }

        if (!hasTransactions) {
            System.out.println("No transactions found for vendor: " + vendorName);
        } else {
            System.out.printf("Total Amount for %s: %.2f%n", vendorName, totalAmount);
        }

        System.out.println("--------------------------------------------------------");
    }
}
