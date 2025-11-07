package com.pluralsight.toppings;

import com.pluralsight.OrderItem;


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

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public  double getPrice(int sandwichSize) {
        return 0;
    }
}
