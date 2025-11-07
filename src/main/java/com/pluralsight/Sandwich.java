package com.pluralsight;

public class Sandwich {
    protected int size; // 4", 8" , 12"
    protected String breadType,toppings; //white, wheat, rye, wrap
    protected boolean isToasted;

    public Sandwich(int size, String breadType, boolean isToasted, String toppings) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = toppings;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
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
}
