package com.pluralsight;

import java.time.LocalDate;

public class Reports {

    public static void monthToDateTransactionReport() {
        System.out.println("Month-to-Date Transaction Report");
        System.out.println("--------------------------------------------------------");

        // Get the current date
        LocalDate today = LocalDate.now();
        // Get the first day of the current month
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the month and not after today, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfMonth) && !ledger.getTransactionDate().isAfter(today)) {
                Ledger.printLedger(ledger);
                totalAmount += ledger.getAmount();
                hasTransactions = true;
            }
        }

        // if theres no transactions, print a message, otherwise print the total amount
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
        // Get the first day of the previous month
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
        // Get the last day of the previous month
        LocalDate lastDayOfPreviousMonth = firstDayOfCurrentMonth.minusDays(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the previous month and not after the last day of the previous month, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfPreviousMonth) && !ledger.getTransactionDate().isAfter(lastDayOfPreviousMonth)) {
                Ledger.printLedger(ledger);
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
        // Get the first day of the current year
        LocalDate firstDayOfYear = today.withDayOfYear(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the year and not after today, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfYear) && !ledger.getTransactionDate().isAfter(today)) {
                Ledger.printLedger(ledger);
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
        // Get the first day of the previous year
        LocalDate firstDayOfPreviousYear = firstDayOfCurrentYear.minusYears(1);
        // Get the last day of the previous year
        LocalDate lastDayOfPreviousYear = firstDayOfCurrentYear.minusDays(1);

        double totalAmount = 0.0;
        boolean hasTransactions = false;

        // for each ledger that is not before the first day of the previous year and not after the last day of the previous year, print those ledgers
        for (Ledger ledger : Ledger.ledgerList) {
            if (!ledger.getTransactionDate().isBefore(firstDayOfPreviousYear) && !ledger.getTransactionDate().isAfter(lastDayOfPreviousYear)) {
                Ledger.printLedger(ledger);
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
}
