package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(OrderItem::getPrice).sum();
    }

    public void printReceipt() {
        System.out.println("\n=== RECEIPT ===");
        for (OrderItem item : items) {
            System.out.println(item.getName() + " - $" + String.format("%.2f", item.getPrice()));
            System.out.println("  " + item.getDescription());
        }
        System.out.println("---------------------");
        System.out.printf("TOTAL: $%.2f%n", getTotal());
    }
}
