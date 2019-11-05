package com.example.eurder.api.item.dtos;

public class ItemDto {

    private String id;
    private String name;
    private String description;
    private double priceInEuro;
    private int amountInStock;

    public ItemDto setId(String id) {
        this.id = id;
        return this;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto setPriceInEuro(double priceInEuro) {
        this.priceInEuro = priceInEuro;
        return this;
    }

    public ItemDto setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
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
}
