package com.pluralsight;

public class Chips implements OrderItem {

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
