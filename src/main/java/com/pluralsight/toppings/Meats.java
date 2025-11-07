package com.pluralsight.toppings;

public class Meats extends Toppings {
    public Meats(String name, boolean isExtra) {
        super(name, true, isExtra);
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
}
