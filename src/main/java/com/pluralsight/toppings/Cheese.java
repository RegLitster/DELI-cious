package com.pluralsight.toppings;

import java.util.List;

public class Cheese extends Toppings {
    public Cheese(String name, boolean isExtra) {
        super(name, true, isExtra);

    }
    private static final List<String> cheeses = List.of(
            "american", "provolone", "cheddar", "swiss"
    );

    public static boolean isValidCheese(String name) {
        return cheeses.contains(name.toLowerCase());
    }

    @Override
    public double getPrice(int sandwichSize) {
        double price = switch (sandwichSize) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0;
        };

        if (isExtra) {
            double extra = switch (sandwichSize) {
                case 4 -> 0.30;
                case 8 -> 0.60;
                case 12 -> 0.90;
                default -> 0;
            };
            price += extra;
        }
        return price;
    }
    @Override
    public String getName() {
        return isExtra ? name + " (Extra Cheese)" : name;
    }
}
