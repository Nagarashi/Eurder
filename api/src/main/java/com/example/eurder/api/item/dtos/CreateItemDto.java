package com.example.eurder.api.item.dtos;

public class CreateItemDto {

    private String name;
    private String description;
    private double priceInEuro;
    private int amountInStock;

    public CreateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public CreateItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateItemDto setPriceInEuro(double priceInEuro) {
        this.priceInEuro = priceInEuro;
        return this;
    }

    public CreateItemDto setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
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
