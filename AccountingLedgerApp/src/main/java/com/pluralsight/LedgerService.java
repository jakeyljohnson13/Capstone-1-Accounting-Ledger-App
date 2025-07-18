package com.pluralsight;

import java.time.format.DateTimeFormatter;

import static com.pluralsight.Ledger.ledgerList;

public class LedgerService {
    public static void printLedger(Ledger _ledger) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(_ledger.getTransactionDate().format(dateFormatter) + "|" + _ledger.getTransactionTime().format(timeFormatter) + "|" + _ledger.getDescription() + "|" + _ledger.getVendor() + "|" + _ledger.getAmount());
    }
    public static void printAllLedgers() {
        if (ledgerList.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Ledger ledger : ledgerList) {
            printLedger(ledger);
            System.out.println("--------------------------------------------------------");
        }
    }
    public static void displayDeposits() {
        boolean hasDeposits = false;
        for (Ledger ledger : ledgerList) {
            if (ledger.getAmount() > 0) {
                printLedger(ledger);
                System.out.println("--------------------------------------------------------");
                hasDeposits = true;
            }
        }
        if (!hasDeposits) {
            System.out.println("No deposits found.");
        }
    }


    public static void displayPayments() {
        boolean hasPayments = false;
        for (Ledger ledger : ledgerList) {
            if (ledger.getAmount() < 0) {
                printLedger(ledger);
                System.out.println("--------------------------------------------------------");
                hasPayments = true;
            }
        }
        if (!hasPayments) {
            System.out.println("No payments found.");
        }


    }

}
