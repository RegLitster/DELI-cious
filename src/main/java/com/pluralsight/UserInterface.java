package com.pluralsight;

import java.util.List;
import java.util.Scanner;

import com.pluralsight.toppings.*;

public class UserInterface {
    private final Scanner scan;
    private Receipt currentOrder;

    public UserInterface() {
        scan = new Scanner(System.in);
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

        String choice = scan.nextLine();

        switch (choice) {
            case "1" -> {
                currentOrder = new Receipt();
                orderScreen();
            }
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

            String choice = scan.nextLine();

            switch (choice) {
                case "1" -> currentOrder.addItem(addSandwichScreen());
                case "2" -> currentOrder.addItem(addDrinkScreen());
                case "3" -> currentOrder.addItem(addChipsScreen());
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

    private Sandwich addSandwichScreen() {
        System.out.println("\n=== Add Sandwich ===");

        System.out.println("Select sandwich size: (4\", 8\", 12\")");
        String size = scan.nextLine();

        System.out.println("Select your bread: (white, wheat, rye, or wrap)");
        String breadType = scan.nextLine().toLowerCase();

        Sandwich sandwich = new Sandwich(size+"\"", breadType, false);

        System.out.println("Select toppings:");
        System.out.println("""
                Meats or type none:
                 - steak
                 - ham
                 - salami
                 - roast beef
                 - chicken
                 - bacon""");
        String meat = scan.nextLine().trim().toLowerCase();

        if (!meat.equals("none")) {
            System.out.print("Would you like extra? (Y/N): ");
            String extra = scan.nextLine().trim().toLowerCase();
            boolean isExtra = extra.equals("y");
            sandwich.addToppings(new Meats(meat, isExtra));
        } else {
            System.out.println("No meat added.");
        }

        System.out.println("""
                Cheese or type none:
                - american
                - provolone
                - cheddar
                - swiss""");
        String cheese = scan.nextLine().trim().toLowerCase();

        if (!cheese.equals("none")) {
            System.out.print("Would you like extra? (Y/N): ");
            boolean extraCheese = scan.nextLine().trim().equals("y");
            sandwich.addToppings(new Cheese(cheese, extraCheese));
        } else {
            System.out.println("No cheese added.");
        }

        System.out.println("""
                Regular Toppings (type one at a time and type "done" when finished):
                - lettuce
                - peppers
                - onions
                - tomatoes
                - jalapenos
                - cucumbers
                - pickles
                - guacamole
                - mushrooms
                """);
        while (true) {
            System.out.print("Topping: ");
            String topping = scan.nextLine().trim().toLowerCase();
            if (topping.equals("done")) break;

            if (RegularToppings.isValidTopping(topping)) {
                sandwich.addToppings(new RegularToppings(topping, false));
            } else {
                System.out.println("Invalid topping. Please choose from the list above.");
            }
        }
        System.out.println("""
                Sauces (type one at a time and type "done" when finished)
                - mayo
                - mustard
                - ketchup
                - ranch
                - thousand islands
                - vinaigrette
                """);
        while (true) {
            System.out.print("Sauce: ");
            String sauce = scan.nextLine().trim().toLowerCase();
            if (sauce.equals("done")) break;

            if (RegularToppings.isValidSauce(sauce)) {
                sandwich.addToppings(new RegularToppings(sauce, false));
            } else {
                System.out.println("Invalid sauce. Please choose from the list above.");
            }
        }

        System.out.print("Would you like the sandwich toasted? (Y/N): ");
        String toasted = scan.nextLine().toLowerCase();
        switch (toasted) {
            case "y" -> sandwich.setToasted(true);
            case "n" -> sandwich.setToasted(false);
        }
        System.out.println("Sandwich added!");
        System.out.println(sandwich.getDescription());
        System.out.printf("Price: $%.2f%n", sandwich.getPrice());


        return sandwich;
    }

    private Drink addDrinkScreen() {
        System.out.println("\n=== Add Drink ===");

        String size;
        while (true) {
            System.out.println("Select drink size (small, medium, large): ");
            size = scan.nextLine().trim().toLowerCase();
            if (Drink.isValidSize(size)) break;
            System.out.println("Invalid size. Please select from small, medium, or large.");
        }

        String flavor;
        while (true) {
            System.out.println("Select drink flavor (Pepsi, Dr Pepper, Starry, Diet Pepsi): ");
            flavor = scan.nextLine().trim();
            if (Drink.isValidFlavor(flavor)) {
                flavor = Drink.normalizeFlavor(flavor);
                break;
            }
            System.out.println("Invalid flavor. Please select from the list above.");
        }

        Drink drink = new Drink(size, flavor);
        System.out.printf("Added %s %s ($%.2f)\n", size, flavor, drink.getPrice());
        return drink;
    }


    private Chips addChipsScreen() {
        System.out.println("\n=== Add Chips ===");

        String flavor;
        while (true) {
            System.out.println("Select chip flavor (Lays, Doritos, BBQ, Sour Cream): ");
            flavor = scan.nextLine().trim();
            if (Chips.isValidFlavor(flavor)) {
                flavor = Chips.normalizeFlavor(flavor);
                break;
            }
            System.out.println("Invalid flavor. Please select from the list above.");
        }

        Chips chips = new Chips(flavor);
        System.out.printf("Added %s ($%.2f)\n", flavor, chips.getPrice());
        return chips;
    }


    private void checkoutScreen() {
        System.out.println("\n=== Checkout ===");
        currentOrder.printReceipt();

        System.out.println("""
                1: Confirm Order
                0: Cancel Order
                Please Select an Option""");

        String choice = scan.nextLine();

        switch (choice) {
            case "1" -> {
                currentOrder.saveReceipt();
                System.out.println("Receipt created! Returning to Home Screen...");
            }
            case "0" -> System.out.println("Order canceled. Returning to Home Screen...");
            default -> System.out.println("Invalid selection. Returning to Home Screen...");
        }
    }
}