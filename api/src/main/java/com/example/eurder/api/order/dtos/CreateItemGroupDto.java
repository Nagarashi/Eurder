package com.example.eurder.api.order.dtos;

import com.example.eurder.domain.item.Item;

public class CreateItemGroupDto {

    private Item item;
    private int orderAmount;

    public CreateItemGroupDto setItem(Item item) {
        this.item = item;
        return this;
    }

    public CreateItemGroupDto setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
