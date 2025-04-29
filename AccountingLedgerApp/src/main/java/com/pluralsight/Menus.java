package com.pluralsight;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menus {

static Scanner read = new Scanner(System.in);

    public static void startMenu() throws InterruptedException {
        System.out.println("Welcome to the ACG Banking System!");
        System.out.println("Enter 1 to start the program");
        System.out.println("Enter any other key to exit the program");
        System.out.print("> ");
        int start = read.nextInt();
        read.nextLine();

        boolean running = false;
        String art = """
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
                    for (int i = 0; i <= 100; i+=20) {
                        System.out.print("\rLoading: [" + "=".repeat(i/10) + "] " + i + "%");
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                    break;
                case 2:
                    System.out.println("Making a payment...");
                    for (int i = 0; i <= 100; i+=20) {
                        System.out.print("\rLoading: [" + "=".repeat(i/10) + "] " + i + "%");
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                    // Call method to handle payment
                    break;
                case 3:
                    System.out.println("Accessing the ledger...");
                    for (int i = 0; i <= 100; i+=20) {
                        System.out.print("\rLoading: [" + "=".repeat(i/10) + "] " + i + "%");
                        TimeUnit.MILLISECONDS.sleep(200);
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

    public static void ledgerMenu() {
        // Placeholder for ledger menu functionality
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
                Ledger.displayLedgers(Ledger.getLedgerList());
                break;
            case 2:
                System.out.println("Showing deposits...");
                // Call method to show deposits
                break;
            case 3:
                System.out.println("Showing payments...");
                // Call method to show payments
                break;
            case 4:
                System.out.println("Viewing reports...");
                // Call method to view reports
                break;
            case 5:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                ledgerMenu(); // Recursively call the menu for invalid input
                break;
        }
    };
}
