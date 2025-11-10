package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
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
            if(item instanceof Sandwich){
            System.out.println("\n" + item.getDescription());
        }}
        System.out.println("---------------------");
        System.out.printf("TOTAL: $%.2f%n", getTotal());
    }

    public void saveReceipt() {
        String timestamp = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/ReceiptFolder/"+timestamp+".txt"))) {
            writer.write("=== RECEIPT ===\n");
            for (OrderItem item : items) {
                writer.write(item.getName() + " - $" + String.format("%.2f", item.getPrice()) + "\n");
                if (item instanceof Sandwich) {
                    writer.write(item.getDescription() + "\n");
                }
            }
            writer.write("---------------------\n");
            writer.write(String.format("TOTAL: $%.2f%n", getTotal()));
        } catch (java.io.IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}
