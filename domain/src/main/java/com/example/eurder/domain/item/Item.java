package com.example.eurder.domain.item;

import java.util.UUID;

public class Item {

    private final String id;
    private String name;
    private String description;
    private double priceInEuro;
    private int amountInStock;

    public Item(Item that) {
        this(that.getName(), that.getDescription(), that.getPriceInEuro(), that.getAmountInStock());
    }

    public Item(String name, String description, double priceInEuro, int amountInStock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.priceInEuro = priceInEuro;
        this.amountInStock = amountInStock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceInEuro() {
        return priceInEuro;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setItemsInStock(int amount) {
        if (amount > this.getAmountInStock())
            amountInStock = 0;
        amountInStock -= amount;
    }
}
