package com.example.eurder.api.order.dtos;

import com.example.eurder.api.item.dtos.ItemDto;

import java.time.LocalDate;

public class ItemGroupDto {

    private ItemDto item;
    private double pricePerItemGroup;
    private int orderAmount;
    private LocalDate shippingDate;

    public ItemGroupDto setItem(ItemDto item) {
        this.item = item;
        return this;
    }

    public ItemGroupDto setTotalPrice(double pricePerItemGroup) {
        this.pricePerItemGroup = pricePerItemGroup;
        return this;
    }

    public ItemGroupDto setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
        return this;
    }

    public ItemGroupDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public ItemDto getItem() {
        return item;
    }

    public double getPricePerItemGroup() {
        return pricePerItemGroup;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
