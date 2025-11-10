package com.pluralsight;

import java.util.List;

public class Chips implements OrderItem {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    private static final List<String> flavors = List.of("Lays", "Doritos", "BBQ", "Sour Cream");

    public static boolean isValidFlavor(String flavor) {
        return flavors.stream().anyMatch(f -> f.equalsIgnoreCase(flavor));
    }

    public static String normalizeFlavor(String flavor) {
        return flavors.stream()
                .filter(f -> f.equalsIgnoreCase(flavor))
                .findFirst()
                .orElse("Lays");
    }

    @Override
    public String getName() {
        return "Chips: " + flavor;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getDescription() {
        return switch (flavor) {
            case "Lays" -> "Lays";//Lays, Doritos, BBQ, Sour Cream
            case "Doritos" -> "Doritos";
            case "BBQ" -> "BBQ";
            case "Sour Cream" -> "Sour Cream";
            default -> "Cheetos";

        };
    }
}
