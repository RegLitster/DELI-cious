package com.pluralsight.toppings;

public class RegularToppings extends Toppings {
    public RegularToppings(String name,boolean isExtra) {
        super(name, false, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0;
    }
}
