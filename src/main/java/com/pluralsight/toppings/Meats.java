package com.pluralsight.toppings;

import java.util.List;

public class Meats extends Toppings {
    public Meats(String name, boolean isExtra) {
        super(name, true, isExtra);
    }

    private static final List<String> meats = List.of(
            "steak", "ham", "salami", "roast beef",
            "chicken", "bacon"
    );

    public static boolean isValidMeat(String name) {
        return meats.contains(name.toLowerCase());
    }

    @Override
    public double getPrice(int sandwichSize) {
        double price = switch (sandwichSize) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0;
        };

        if (isExtra) {
            double extra = switch (sandwichSize) {
                case 4 -> 0.50;
                case 8 -> 1.00;
                case 12 -> 1.50;
                default -> 0;
            };
            price += extra;
        }
        return price;
    }
    @Override
    public String getName() {
        return isExtra ? name + " (Extra Meat)" : name;
    }
}
