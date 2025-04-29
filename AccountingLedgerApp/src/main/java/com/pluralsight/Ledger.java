package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Ledger {
    private LocalDate transactionDate;
    private LocalTime transactionTime ;
    private String description;
    private String vendor;
    private double amount;
    static List<Ledger> ledgerList = new ArrayList<>();


//    public static void main(String[] args) {
//        Ledger ledger = new Ledger();
//        ledger.setTransactionDate(LocalDate.now());
//        LocalTime TransactionTime = (LocalTime.now());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        String formattedTime = TransactionTime.format(formatter);
//        ledger.setTransactionTime(LocalTime.parse(formattedTime, formatter));
//
//        ledger.setDescription("Grocery Shopping");
//        ledger.setVendor("Supermarket");
//        ledger.setAmount(150.75);
//
//        List<Ledger> ledgerList = new ArrayList<>();
//        ledgerList.add(ledger);
//
//        displayLedger(ledgerList);
//    }

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
    public static List<Ledger> getLedgerList() {return ledgerList;}

    public void setTransactionDate(LocalDate transactionDate) {this.transactionDate = transactionDate;}
    public void setTransactionTime(LocalTime transactionTime) {this.transactionTime = transactionTime;}
    public void setDescription(String description) {this.description = description;}
    public void setVendor(String vendor) {this.vendor = vendor;}
    public void setAmount(double amount) {this.amount = amount;}

    public static void printLedger(Ledger _ledger) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Transaction Date: " + _ledger.getTransactionDate().format(dateFormatter));
        System.out.println("Transaction Time: " + _ledger.getTransactionTime().format(timeFormatter));
        System.out.println("Description: " + _ledger.getDescription());
        System.out.println("Vendor: " + _ledger.getVendor());
        System.out.printf("Amount: $%.2f%n", _ledger.getAmount());
    }


    public static List displayLedgers(List<Ledger> ledgerList) {
        if (ledgerList.isEmpty()) {
            System.out.println("No transactions in the ledger.");
            return null;
        }

        for (Ledger ledger : ledgerList) {
            printLedger(ledger);
            System.out.println("-------------------------------");
        }
        return List.of(ledgerList);
    }

    public static void readFromTransactionCsv() {
        // This method can be implemented to read transactions from a CSV file
        // and populate the ledgerList with Ledger objects.
        // For now, this is just a placeholder.
        try {
            FileReader fileReader = new FileReader("transaction.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line;
            bufReader.readLine();
            while ((line = bufReader.readLine()) != null) {
                String[] column = line.split("\\|");
                if(column.length == 5) {
                    LocalDate transactionDate = LocalDate.parse(column[0]);
                    LocalTime transactionTime = LocalTime.parse(column[1]);
                    String description = column[2];
                    String vendor = column[3];
                    double amount = Double.parseDouble(column[4]);

                    Ledger ledger = new Ledger(transactionDate, transactionTime, description, vendor, amount);
                    ledgerList.add(ledger);

                }
            }
            bufReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading transactions from CSV: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
