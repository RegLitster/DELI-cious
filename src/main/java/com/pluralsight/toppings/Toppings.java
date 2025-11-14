package com.pluralsight.toppings;

public abstract class Toppings {
    protected String name;
    protected boolean isPremium;
    protected boolean isExtra;

    public Toppings(String name, boolean isPremium, boolean isExtra) {
        this.name = name;
        this.isPremium = isPremium;
        this.isExtra = isExtra;

    }
    public String getName() {
        return name;
    }

    public  double getPrice(int sandwichSize) {
        return 0;
    }
}
