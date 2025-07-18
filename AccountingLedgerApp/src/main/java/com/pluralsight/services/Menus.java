package com.pluralsight.services;

import com.pluralsight.models.Reports;
import com.pluralsight.data.Transactions;
import com.pluralsight.models.Ledger;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static com.pluralsight.models.AsciiArt.*;

public class Menus {

static Scanner read = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("Welcome to the ACG Banking System!");
        System.out.println("Enter 1 to start the program");
        System.out.println("Enter any other key to exit the program");
        System.out.print("> ");
        int start = read.nextInt();
        read.nextLine();

        boolean running = false;

        if (start == 1) {
            try {
                // converts art to a character array and prints it character by character with a delay
                for (char c : art.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(1); // Adjust the delay (milliseconds) to control speed
                    running = true;
                }
                System.out.println("-------------------------------------------------");
                for (char c : menuArt.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interrupted while displaying art.");
            }
        } else {
            System.out.println("Exiting the program...");
            System.exit(0);
        }

        while (running) {
            System.out.println("\n------Welcome------");
            System.out.println("1 | Make a Deposit");
            System.out.println("2 | Make a Payment");
            System.out.println("3 | Ledger");
            System.out.println("4 | Exit the Program");
            System.out.print("> ");

            String choiceStr = read.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    continue;
                }
                switch (choice) {
                    case 1:
                        // Call method to handle deposit
                        System.out.println("Loading deposit screen...");
                        loadingBar();
                        System.out.println("----------------------------");
                        Transactions.makeDeposit();
                        break;
                    case 2:
                        System.out.println("Loading payment screen...");
                        loadingBar();
                        System.out.println("----------------------------");
                        Transactions.makePayment();
                        break;
                    case 3:
                        System.out.println("Accessing the ledger menu...");
                        loadingBar();
                        System.out.println("------------------------------------");
                        for (char c : ledgerArt.toCharArray()) {
                            System.out.print(c);
                            Thread.sleep(1);
                        }
                        ledgerMenu();
                        break;
                    case 4:
                        System.out.println("Exiting the program...");
                        System.out.println("------------------------------------------------");
                        for (char c : exitArt.toCharArray()) {
                            System.out.print(c);
                            Thread.sleep(1);
                        }
                        running = false;
                        break;
                }

            } catch (NumberFormatException | InterruptedException e) {
                System.out.println("Invalid input. Please enter a number (1-4).");
            }
        }

    }


    public static void ledgerMenu() {

        Ledger.readFromTransactionCsv();

        while (true) {
            System.out.println("\n------Ledger Menu------");
            System.out.println("1 | Display All Transactions");
            System.out.println("2 | Show Deposits");
            System.out.println("3 | Show Payments");
            System.out.println("4 | View Reports");
            System.out.println("5 | Return to Main Menu");
            System.out.print("> ");

            String choiceStr = read.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Displaying all transactions...");
                        loadingBar();
                        System.out.println("----------------------------");
                        // Call method to display all transactions
                        LedgerService.printAllLedgers();
                        break;
                    case 2:
                        System.out.println("Showing deposits...");
                        loadingBar();
                        System.out.println("----------------------------");
                        // Call method to show deposits
                        LedgerService.displayDeposits();
                        break;
                    case 3:
                        System.out.println("Showing payments...");
                        loadingBar();
                        System.out.println("----------------------------");
                        // Call method to show payments
                        LedgerService.displayPayments();
                        break;
                    case 4:
                        System.out.println("Accessing reports menu...");
                        loadingBar();
                        System.out.println("---------------------------------------");
                        for (char c : reportArt.toCharArray()) {
                            System.out.print(c);
                            Thread.sleep(1);
                        }
                        // Call method to view reports menu
                        reportsMenu();
                        break;
                    case 5:
                        System.out.println("Returning to main menu...");
                        loadingBar();
                        System.out.println("-----------------------------------------------------");
                        for (char c : menuArt.toCharArray()) {
                            System.out.print(c);
                            Thread.sleep(1);
                        }
                        return;
                }

            } catch (NumberFormatException | InterruptedException e) {
                System.out.println("Invalid input. Please enter a number (1-5).");
            }
        }
    }


    public static void reportsMenu() {
        while (true) {
            System.out.println("\n------Reports Menu------");
            System.out.println("1 | Sort by Month to Date");
            System.out.println("2 | Sort by Previous Month");
            System.out.println("3 | Sort by Year to Date");
            System.out.println("4 | Sort by Previous Year");
            System.out.println("5 | Search by Vendor");
            System.out.println("6 | Return to Ledger Menu");
            System.out.print("> ");

            String choiceStr = read.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Sorting by month to date...");
                        loadingBar();
                        System.out.println("-----------------------------");
                        // Call method to sort by month to date
                        Reports.monthToDateTransactionReport();
                        break;
                    case 2:
                        System.out.println("Sorting by previous month...");
                        loadingBar();
                        System.out.println("----------------------------");
                        // Call method to sort by previous month
                        Reports.previousMonthTransactionReport();
                        break;
                    case 3:
                        System.out.println("Sorting by year to date...");
                        loadingBar();
                        System.out.println("----------------------------");
                        // Call method to sort by year to date
                        Reports.yearToDateTransactionReport();
                        break;
                    case 4:
                        System.out.println("Sorting by previous year...");
                        loadingBar();
                        System.out.println("----------------------------");
                        // Call method to sort by previous year
                        Reports.previousYearTransactionReport();
                        break;
                    case 5:
                        System.out.println("Searching by vendor...");
                        loadingBar();
                        System.out.println("----------------------------");
                        // Call method to search by vendor
                        Reports.searchByVendorReport();
                        break;
                    case 6:
                        System.out.println("Returning to ledger menu...");
                        loadingBar();
                        System.out.println("--------------------------------------");
                        for (char c : ledgerArt.toCharArray()) {
                            System.out.print(c);
                            Thread.sleep(1); // Adjust the delay (milliseconds) to control speed
                        }
                        return;
                }
            } catch (NumberFormatException | InterruptedException e) {
                System.out.println("Invalid input. Please enter a number (1-6).");
            }

        }

    }


    public static void loadingBar() {
        try {
            for (int i = 0; i <= 100; i += 20) {
                System.out.print("\rLoading: [" + "=".repeat(i / 5) + "] " + i + "%");
                TimeUnit.MILLISECONDS.sleep(100);
            }
            System.out.println("\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Loading interrupted.");
        }
    }
}
