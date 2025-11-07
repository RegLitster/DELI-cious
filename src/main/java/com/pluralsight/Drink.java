package com.pluralsight;

public class Drink implements OrderItem {
    private String size;
    private final String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public String getName() {
        return "";
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
        return "";
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return switch (flavor) {
            case "Pepsi" -> "Pepsi";
            case "Dr Pepper" -> "Dr Pepper";
            case "Starry" -> "Starry";
            case "Diet Coke" -> "Diet Coke";
            default -> "Pepsi";
        };
    }
}
