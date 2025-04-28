package com.pluralsight;

import java.util.Scanner;

public class Menus {

static Scanner read = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("Welcome to the KG Banking System!");
        System.out.println("Enter 1 to start the program");
        System.out.println("Enter any other key to exit the program");
        System.out.print("> ");
        int start = read.nextInt();
        read.nextLine();

        boolean running = false;
        String art = "+=============================================+\n" +
                     "| __  __ ____                                 |\n" +
                     "||  |/  / (_,`                                |\n" +
                     "||__|\\__\\____)                                |\n" +
                     "|_____  ____  __  _ __  __ _ __  _ ____       |\n" +
                     "|| () )/ () \\|  \\| |  |/  / |  \\| / (_,`      |\n" +
                     "||_()_)__/\\__\\_|\\__|__|\\__\\_|_|\\__\\____)      |\n" +
                     "|  ____ __  __ ____  _____ ____ __  __   ____ |\n" +
                     "| (_ (_`\\ \\/ /(_ (_`|_   _| ===|  \\/  | (_ (_`|\n" +
                     "|.__)__) |__|.__)__)  |_| |____|_|\\/|_|.__)__)|\n" +
                     "+=============================================+";


        if (start == 1) {
            try {
                for (char c : art.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(15); // Adjust the delay (milliseconds) to control speed.  I reduced it for this art.
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

        }

    }
}
