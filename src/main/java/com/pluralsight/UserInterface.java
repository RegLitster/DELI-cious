package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            running = homeScreen();
        }

        System.out.println("Thank you for using the Sandwich Shop!");
    }

    private boolean homeScreen() {
        System.out.println("\n=== Home Screen ===");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Select an option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                orderScreen();
                break;
            case "0":
                return false;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
        return true;
    }

    private void orderScreen() {
        boolean inOrder = true;

        while (inOrder) {
            System.out.println("\n=== Order Screen ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addSandwichScreen();
                    break;
                case "2":
                    addDrinkScreen();
                    break;
                case "3":
                    addChipsScreen();
                    break;
                case "4":
                    checkoutScreen();
                    inOrder = false; // after checkout, return home
                    break;
                case "0":
                    System.out.println("Order canceled. Returning to Home Screen...");
                    inOrder = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void addSandwichScreen() {
        System.out.println("\n=== Add Sandwich ===");
        System.out.println("Select your bread:");
        // Placeholder for bread selection logic

        System.out.println("Select sandwich size:");
        // Placeholder for size selection

        System.out.println("Select toppings:");
        System.out.println("  Meat:");
        // Placeholder for meat options
        System.out.println("  Cheese:");
        // Placeholder for cheese options
        System.out.println("  Other toppings:");
        // Placeholder for other toppings
        System.out.println("  Sauces:");
        // Placeholder for sauces

        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        String toasted = scanner.nextLine();

        System.out.println("Sandwich added! (Placeholder)\n");
    }

    private void addDrinkScreen() {
        System.out.println("\n=== Add Drink ===");
        System.out.println("Select drink size:");
        // Placeholder for size logic

        System.out.println("Select drink flavor:");
        // Placeholder for flavor logic

        System.out.println("Drink added! (Placeholder)\n");
    }

    private void addChipsScreen() {
        System.out.println("\n=== Add Chips ===");
        System.out.println("Select chip type:");
        // Placeholder for chip selection

        System.out.println("Chips added! (Placeholder)\n");
    }

    private void checkoutScreen() {
        System.out.println("\n=== Checkout ===");
        System.out.println("Order details (Placeholder)");
        System.out.println("Total price: (Placeholder)");

        System.out.println("\n1) Confirm Order");
        System.out.println("0) Cancel");
        System.out.print("Select an option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Receipt created! Returning to Home Screen...");
                // Placeholder for receipt creation
                break;
            case "0":
                System.out.println("Order canceled. Returning to Home Screen...");
                break;
            default:
                System.out.println("Invalid selection. Returning to Home Screen...");
        }
    }
}
