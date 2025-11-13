package com.pluralsight.toppings;

import java.util.List;

public class RegularToppings extends Toppings {

    private static final List<String> regularToppings = List.of(
            "lettuce", "peppers", "onions", "tomatoes",
            "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms"
    );

    private static final List<String> sauces = List.of(
            "mayo", "mustard", "ketchup", "ranch",
            "thousand islands", "vinaigrette"
    );

    public RegularToppings(String name, boolean isExtra) {
        super(name, false, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0;
    }

    public static boolean isValidSauce(String name) {
        return sauces.contains(name.toLowerCase());
    }

    public static boolean isValidTopping(String name) {
        return regularToppings.contains(name.toLowerCase());
    }

}
