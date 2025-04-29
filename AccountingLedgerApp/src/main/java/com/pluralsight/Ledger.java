package com.pluralsight;

import java.io.*;
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


    public Ledger() {

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

    // method for reading transactions from CSV and adding them to the ledgerList
    public static void readFromTransactionCsv() {
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

    // method for writing transactions to CSV, when read they are added to the ledgerList
    public static void writeToTransactionCsv(String _vendor, String _description, double _amount) {
        LocalDate transactionDate = LocalDate.now();
        LocalTime transactionTime = LocalTime.now();
        try {
            FileWriter fileWriter = new FileWriter("transaction.csv" , true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            File file = new File("transaction.csv");
            // Check if the file is empty
            if (!file.exists() || file.length() == 0) {
                // Write the header if the file is empty
                writer.write("Date|Time|Description|Vendor|Amount\n");
            }
            // Write the transaction details
            String formattedDate = transactionDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String formattedTime = transactionTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            writer.append(formattedDate).append("|").append(formattedTime).append("|").append(_description).append("|").append(_vendor).append("|").append(String.valueOf(_amount)).append("\n");
            writer.close();

            if (_amount > 0) {
                System.out.println("Deposit of $" + _amount + " made to " + _vendor + " with description: " + _description);
            } else {
                System.out.println("Payment of $" + Math.abs(_amount) + " made to " + _vendor + " with description: " + _description);
            }
        } catch (IOException e) {
            System.out.println("Error writing transactions to CSV: " + e.getMessage());
        }
    }




}
