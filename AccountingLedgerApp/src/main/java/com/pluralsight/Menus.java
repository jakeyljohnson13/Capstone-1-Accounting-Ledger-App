package com.pluralsight;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menus {

static Scanner read = new Scanner(System.in);

        static String art = """
                ╔───────────────────────────────────────────╗
                │     _    ____ ____                        │
                │    / \\  / ___/ ___|                       │
                │   / _ \\| |  | |  _                        │
                │  / ___ \\ |__| |_| |                       │
                │ /_/__ \\_\\____\\____| _  _____ _   _  ____  │
                │ | __ )  / \\  | \\ | | |/ /_ _| \\ | |/ ___| │
                │ |  _ \\ / _ \\ |  \\| | ' / | ||  \\| | |  _  │
                │ | |_) / ___ \\| |\\  | . \\ | || |\\  | |_| | │
                │ |____/_/   \\_\\_| \\_|_|\\_\\___|_| \\_|\\____| │
                ╚───────────────────────────────────────────╝
                """;

        static String ledgerArt = """
                \n
                ╔──────────────────────────────────╗
                │ _              _                 │
                │| |            | |                │
                │| |     ___  __| | __ _  ___ _ __ │
                │| |    / _ \\/ _` |/ _` |/ _ \\ '__|│
                │| |___|  __/ (_| | (_| |  __/ |   │
                │|______\\___|\\__,_|\\__, |\\___|_|   │
                │                   __/ |          │
                │                  |___/           │
                ╚──────────────────────────────────╝
                """;

        static String reportArt = """
                \n
                ╔─────────────────────────────────────╗
                │ _____                       _       │
                │|  __ \\                     | |      │
                │| |__) |___ _ __   ___  _ __| |_ ___ │
                │|  _  // _ \\ '_ \\ / _ \\| '__| __/ __|│
                │| | \\ \\  __/ |_) | (_) | |  | |_\\__ \\│
                │|_|  \\_\\___| .__/ \\___/|_|   \\__|___/│
                │           | |                       │
                │           |_|                       │
                ╚─────────────────────────────────────╝
                """;
    public static void startMenu() throws InterruptedException {
        System.out.println("Welcome to the ACG Banking System!");
        System.out.println("Enter 1 to start the program");
        System.out.println("Enter any other key to exit the program");
        System.out.print("> ");
        int start = read.nextInt();
        read.nextLine();

        boolean running = false;

        if (start == 1) {
            try {
                for (char c : art.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(5); // Adjust the delay (milliseconds) to control speed
                    running = true;
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
            System.out.println("1 | Make a deposit");
            System.out.println("2 | Make a payment");
            System.out.println("3 | Ledger");
            System.out.println("4 | Exit the program");
            int choice = read.nextInt();
            read.nextLine();

            switch (choice) {
                case 1:
                    // Call method to handle deposit
                    System.out.println("Making a deposit...");
                    loadingBar();
                    break;
                case 2:
                    System.out.println("Making a payment...");
                    loadingBar();
                    // Call method to handle payment
                    break;
                case 3:
                    System.out.println("Accessing the ledger...");
                    loadingBar();
                    for (char c : ledgerArt.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(5); // Adjust the delay (milliseconds) to control speed
                    }
                    ledgerMenu();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }

    }

    public static void ledgerMenu() throws InterruptedException {
        // Placeholder for ledger menu functionality

       while(true) {
           System.out.println("\n------Ledger Menu------");
           System.out.println("1 | Display All Transactions");
           System.out.println("2 | Show Deposits");
           System.out.println("3 | Show Payments");
           System.out.println("4 | View Reports");
           System.out.println("5 | Return to Main Menu");
           int choice = read.nextInt();
           read.nextLine();

           switch (choice) {
               case 1:
                   System.out.println("Displaying all transactions...");
                   // Call method to display all transactions
                   loadingBar();
                   Ledger.displayLedgers(Ledger.getLedgerList());
                   break;
               case 2:
                   System.out.println("Showing deposits...");
                   loadingBar();
                   // Call method to show deposits
                   break;
               case 3:
                   System.out.println("Showing payments...");
                   loadingBar();
                   // Call method to show payments
                   break;
               case 4:
                   System.out.println("Viewing reports...");
                   loadingBar();
                   for (char c : reportArt.toCharArray()) {
                       System.out.print(c);
                       Thread.sleep(5); // Adjust the delay (milliseconds) to control spee
                   }
                   reportsMenu();
                   break;
               case 5:
                   System.out.println("Returning to main menu...");
                   loadingBar();
                   return;
               default:
                   System.out.println("Invalid choice. Please try again.");
                   ledgerMenu(); // Recursively call the menu for invalid input
                   break;
           }
       }
    }

    public static void reportsMenu() throws InterruptedException {
        while(true) {
            System.out.println("\n------Reports Menu------");
            System.out.println("1 | Sort by Month to Date");
            System.out.println("2 | Sort by Previous Month");
            System.out.println("3 | Sort by Year to Date");
            System.out.println("4 | Sort by Previous Year");
            System.out.println("5 | Search by Vendor");
            System.out.println("6 | Return to Main Menu");
            int choice = read.nextInt();
            read.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Sorting by month to date...");
                    loadingBar();
                    // Call method to sort by month to date
                    break;
                case 2:
                    System.out.println("Sorting by previous month...");
                    loadingBar();
                    // Call method to sort by previous month
                    break;
                case 3:
                    System.out.println("Sorting by year to date...");
                    loadingBar();
                    // Call method to sort by year to date
                    break;
                case 4:
                    System.out.println("Sorting by previous year...");
                    loadingBar();
                    // Call method to sort by previous year
                    break;
                case 5:
                    System.out.println("Searching by vendor...");
                    loadingBar();
                    // Call method to search by vendor
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    loadingBar();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    ledgerMenu(); // Recursively call the menu for invalid input
                    break;
            }
        }

    }

    public static void loadingBar() throws InterruptedException {
        for (int i = 0; i <= 100; i+=20) {
            System.out.print("\rLoading: [" + "=".repeat(i/10) + "] " + i + "%");
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}
