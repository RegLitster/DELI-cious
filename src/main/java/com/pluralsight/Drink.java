package com.pluralsight;

import java.util.List;

public class Drink implements OrderItem {
    private String size;
    private final String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    private static final List<String> sizes = List.of("Small", "Medium", "Large");
    private static final List<String> flavors = List.of("Pepsi", "Dr Pepper", "Starry", "Diet Pepsi");

    public static boolean isValidSize(String size) {
        return sizes.stream().anyMatch(s -> s.equalsIgnoreCase(size));
    }

    public static boolean isValidFlavor(String flavor) {
        return flavors.stream().anyMatch(f -> f.equalsIgnoreCase(flavor));
    }

    public static String normalizeFlavor(String flavor) {
        return flavors.stream()
                .filter(f -> f.equalsIgnoreCase(flavor))
                .findFirst()
                .orElse("Pepsi");
    }

    @Override
    public String getName() {
        return "Drink: " + size + " " + flavor;
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
    }

    @Override
    public String getDescription() {
        return size + " " + flavor;
    }
}
