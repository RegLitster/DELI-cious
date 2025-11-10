package com.pluralsight;

import com.pluralsight.toppings.Toppings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich implements OrderItem{
    protected String size; // 4", 8" , 12"
    protected String breadType; //white, wheat, rye, wrap
    protected boolean isToasted;
    protected List<Toppings> toppings = new ArrayList<>();

    public Sandwich(String size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public void addToppings(Toppings toppings) {
        this.toppings.add(toppings);
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public int getSize() {
        return switch (size) {
            case "4" -> 4;
            case "8" -> 8;
            case "12" -> 12;
            default -> 0;
        };
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    @Override
    public String getName() {
        return size + " Sandwich " + breadType;
    }

    @Override
    public double getPrice() {
        int sandwichSize = getSize();
        double price = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0.0;
        };
        double totalPrice = toppings.stream()
                .mapToDouble(t -> t.getPrice(sandwichSize))
                .sum();
        return price + totalPrice;
    }

    @Override
    public String getDescription() {
        String toppingsDescription = toppings.stream()
                .map(Toppings::getName)
                .map(name -> "  -" + name)
                .collect(Collectors.joining("\n"));
        return "Bread: " + breadType + (isToasted ? " - Toasted" : "") + "\nToppings:\n" + toppingsDescription+"\n";
    }

}
