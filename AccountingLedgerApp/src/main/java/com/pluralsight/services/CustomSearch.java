package com.pluralsight.services;

import com.pluralsight.models.Ledger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CustomSearch {
    public static void search(List<Ledger> transactions) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Start Date (yyyy-MM-dd): ");
        String s = sc.nextLine().trim();
        System.out.print("End Date (yyyy-MM-dd): ");
        String e = sc.nextLine().trim();
        System.out.print("Description: ");
        String d = sc.nextLine().trim().toLowerCase();
        System.out.print("Vendor: ");
        String v = sc.nextLine().trim().toLowerCase();
        System.out.print("Amount: ");
        String a = sc.nextLine().trim();

        transactions.stream()
                .filter(t -> s.isEmpty() || !t.getTransactionDate().isBefore(LocalDate.parse(s, fmt)))
                .filter(t -> e.isEmpty() || !t.getTransactionDate().isAfter(LocalDate.parse(e, fmt)))
                .filter(t -> d.isEmpty() || t.getDescription().toLowerCase().contains(d))
                .filter(t -> v.isEmpty() || t.getVendor().toLowerCase().contains(v))
                .filter(t -> a.isEmpty() || t.getAmount() == Double.parseDouble(a))
                .forEach(t -> {
                    System.out.println("------------------------------");
                    System.out.println("Date: " + t.getTransactionDate());
                    System.out.println("Time: " + t.getTransactionTime());
                    System.out.println("Description: " + t.getDescription());
                    System.out.println("Vendor: " + t.getVendor());
                    System.out.println("Amount: $" + t.getAmount());
                });
    }
}
