package com.pluralsight;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menus {

static Scanner read = new Scanner(System.in);

    public static void startMenu() throws InterruptedException {
        System.out.println("Welcome to the KG Banking System!");
        System.out.println("Enter 1 to start the program");
        System.out.println("Enter any other key to exit the program");
        System.out.print("> ");
        int start = read.nextInt();
        read.nextLine();

        boolean running = false;
        String art = """
                +=============================================+
                |                __  __ ____                  |
                |               |  |/  / (_,`                 |
                |               |__|\\__\\____)                 |
                |   _____  ____  __  _ __  __ _ __  _ ____    |
                |   | () )/ () \\|  \\| |  |/  / |  \\| / (_,`   |
                |   |_()_)__/\\__\\_|\\__|__|\\__\\_|_|\\__\\____)   |
                |  ____ __  __ ____  _____ ____ __  __   ____ |
                | (_ (_`\\ \\/ /(_ (_`|_   _| ===|  \\/  | (_ (_`|
                |.__)__) |__|.__)__)  |_| |____|_|\\/|_|.__)__)|
                +=============================================+""";

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
                    for (int i = 0; i <= 100; i+=10) {
                        System.out.print("\rLoading: [" + "=".repeat(i/10) + "] " + i + "%");
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                    break;
                case 2:
                    System.out.println("Making a payment...");
                    for (int i = 0; i <= 100; i+=10) {
                        System.out.print("\rLoading: [" + "=".repeat(i/10) + "] " + i + "%");
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                    // Call method to handle payment
                    break;
                case 3:
                    System.out.println("Accessing the ledger...");
                    for (int i = 0; i <= 100; i+=10) {
                        System.out.print("\rLoading: [" + "=".repeat(i/10) + "] " + i + "%");
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                    // Call method to access ledger
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
}
