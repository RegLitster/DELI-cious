package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean run = true;

        while (run) {
            run = homeScreen();
        }

        System.out.println("Thank you for visiting DELi-cious Sub! Goodbye!");
    }

    private boolean homeScreen() {
        System.out.println("""
                === Home Screen ===
                1: New Order
                0: Exit
                Please Select an option:""");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> orderScreen();
            case "0" -> {
                return false;
            }
            default -> System.out.println("Invalid selection. Please try again.");
        }
        return true;
    }

    private void orderScreen() {
        boolean inOrder = true;

        while (inOrder) {
            System.out.println("""
                    === Order Screen ===
                    1: Add Sandwich
                    2: Add Drink
                    3: Add Chips
                    4: Checkout
                    0: Cancel Order
                    Please Select an option:""");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addSandwichScreen();
                case "2" -> addDrinkScreen();
                case "3" -> addChipsScreen();
                case "4" -> {
                    checkoutScreen();
                    inOrder = false;
                }
                case "0" -> {
                    System.out.println("Order canceled. Returning to Home Screen...");
                    inOrder = false;
                }
                default -> System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void addSandwichScreen() {
        System.out.println("\n=== Add Sandwich ===");

        System.out.println("Select sandwich size: (4\", 8\", 12\")");
        // Placeholder for size selection

        System.out.println("Select your bread: (white, wheat, rye, or wrap)");
        // Placeholder for bread selection logic


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

        System.out.println("\n1: Confirm Order");
        System.out.println("0: Cancel");
        System.out.print("Select an option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.println("Receipt created! Returning to Home Screen...");
                // Placeholder for receipt creation
            }
            case "0" -> System.out.println("Order canceled. Returning to Home Screen...");
            default -> System.out.println("Invalid selection. Returning to Home Screen...");

        }
    }
}
