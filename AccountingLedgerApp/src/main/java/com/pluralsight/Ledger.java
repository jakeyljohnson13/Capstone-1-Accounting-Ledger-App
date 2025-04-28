package com.pluralsight;

import java.time.*;
import java.util.ArrayList;
import java.util.List;


public class Ledger {
    private LocalDate transactionDate;
    private LocalTime transactionTime ;
    private String description;
    private String vendor;
    private double amount;
    List<Ledger> ledgerList = new ArrayList<>();
    

    public static void main(String[] args) {
        Ledger ledger = new Ledger();
        ledger.setTransactionDate(LocalDate.of(2023, 10, 1));
        ledger.setTransactionTime(LocalTime.of(14, 30));
        ledger.setDescription("Grocery Shopping");
        ledger.setVendor("Supermarket");
        ledger.setAmount(150.75);

        List<Ledger> ledgerList = new ArrayList<>();
        ledgerList.add(ledger);

        displayLedger(ledgerList);
    }

    public Ledger() {
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalTime.now();
        this.description = "";
        this.vendor = "";
        this.amount = 0.0;
    }

    public Ledger(LocalDate _transactionDate, LocalTime _transactionTime, String _description, String _vendor, double _amount) {
        this.transactionDate = _transactionDate;
        this.transactionTime = _transactionTime;
        this.description = _description;
        this.vendor = _vendor;
        this.amount = _amount;
    }

    public LocalDate getTransactionDate() {return transactionDate;}
    public LocalTime getTransactionTime() {return transactionTime;}
    public String getDescription() {return description;}
    public String getVendor() {return vendor;}
    public double getAmount() {return amount;}
    public List<Ledger> getLedgerList() {return ledgerList;}

    public void setTransactionDate(LocalDate transactionDate) {this.transactionDate = transactionDate;}
    public void setTransactionTime(LocalTime transactionTime) {this.transactionTime = transactionTime;}
    public void setDescription(String description) {this.description = description;}
    public void setVendor(String vendor) {this.vendor = vendor;}
    public void setAmount(double amount) {this.amount = amount;}

    public static void printLedger(Ledger ledger) {
        System.out.println("Transaction Date: " + ledger.getTransactionDate());
        System.out.println("Transaction Time: " + ledger.getTransactionTime());
        System.out.println("Description: " + ledger.getDescription());
        System.out.println("Vendor: " + ledger.getVendor());
        System.out.println("Amount: $" + ledger.getAmount());
    }


    public static void displayLedger(List<Ledger> ledgerList) {
        if (ledgerList.isEmpty()) {
            System.out.println("No transactions in the ledger.");
            return;
        }

        for (Ledger ledger : ledgerList) {
            printLedger(ledger);
            System.out.println("-------------------------------");
        }
    }




}
