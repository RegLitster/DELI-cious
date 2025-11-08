package com.pluralsight;

import java.util.Scanner;

import com.pluralsight.toppings.*;

public class UserInterface {
    private final Scanner scan;
    private Order currentOrder;
    Sandwich sandwich = new Sandwich("", "", false);

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
                currentOrder = new Order();
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
        sandwich.setSize(size); //might be get idk well see

        System.out.println("Select your bread: (white, wheat, rye, or wrap)");
        String breadType = scan.nextLine().toLowerCase();
        sandwich.setBreadType(breadType);


        System.out.println("Select toppings:");
        System.out.println("""
                Meats:
                 - steak
                 - ham
                 - salami
                 - roast beef
                 - chicken
                 - bacon""");
        String meat = scan.nextLine();

        System.out.println("Would you like extra? (Y/N)");//TODO add if they want extra but as a different meat
        boolean extraMeat = scan.nextLine().equalsIgnoreCase("y");

        sandwich.addToppings(new Meats(meat, extraMeat));

        System.out.println("""
                Cheese:
                - american
                - provolone
                - cheddar
                - swiss""");
        String cheese = scan.nextLine();

        System.out.println("Would you like extra? (Y/N)");//TODO same thing with meats
        boolean extraCheese = scan.nextLine().equalsIgnoreCase("y");

        sandwich.addToppings(new Cheese(cheese, extraCheese));

        System.out.println("""
                 Regular Toppings (type one at a time and type "done" when finished):
                     - lettuce
                     - peppers
                     - onions
                     - tomatoes
                     - jalapeños
                     - cucumbers
                     - pickles
                     - guacamole
                     - mushrooms
                """);
        while (true) {
            System.out.print("Topping: ");
            String topping = scan.nextLine().toLowerCase();
            if (topping.equals("done")) break;
            sandwich.addToppings(new RegularToppings(topping, false));
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
            System.out.print("Sauces: ");
            String sauce = scan.nextLine().toLowerCase();
            if (sauce.equals("done")) break;
            sandwich.addToppings(new RegularToppings(sauce, false));

            System.out.print("Would you like the sandwich toasted? (yes/no): ");
            String toasted = scan.nextLine().toLowerCase();
            switch (toasted) {
                case "yes" -> sandwich.setToasted(true);
                case "no" -> sandwich.setToasted(false);
            }
            System.out.println("Sandwich added!");
            System.out.println(sandwich.getDescription());
            System.out.printf("Price: $%.2f%n", sandwich.getPrice());
        }
        return sandwich;
    }

    private Drink addDrinkScreen() {
        System.out.println("\n=== Add Drink ===");
        System.out.println("Select drink size (small, medium, large): ");
        String drinkSize = scan.nextLine().toLowerCase();

        System.out.println("Select drink flavor (Pepsi, Dr Pepper, Starry, Diet Pepsi): ");
        String flavor = scan.nextLine();

        Drink drink = new Drink(drinkSize, flavor);
        System.out.printf("Added %s %s ($%.2f)\n", drinkSize, flavor, drink.getPrice());
        return drink;
    }


    private Chips addChipsScreen() {
        System.out.println("\n=== Add Chips ===");
        System.out.println("Select chip flavor (e.g., Lays, Doritos, BBQ, Sour Cream): ");
        String flavor = scan.nextLine();

        Chips chips = new Chips();
        System.out.printf("Added %s chips ($%.2f)\n", flavor, chips.getPrice());
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
            case "1" -> System.out.println("Receipt created! Returning to Home Screen...");
            case "0" -> System.out.println("Order canceled. Returning to Home Screen...");
            default -> System.out.println("Invalid selection. Returning to Home Screen...");
        }
    }
}