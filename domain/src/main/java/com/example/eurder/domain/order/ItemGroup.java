package com.example.eurder.domain.order;

import com.example.eurder.domain.item.Item;

import java.time.LocalDate;

public class ItemGroup {

    private static final int NEXT_DAY_DELIVERY = 1;
    private static final int NEXT_WEEK_DELIVERY = 7;

    private final Item item;
    private final double totalPriceOfItemGroup;
    private final int orderAmount;
    private final LocalDate shippingDate;

    public ItemGroup(Item item, int orderAmount) {
        this.item = item;
        this.orderAmount = orderAmount;
        this.totalPriceOfItemGroup = getPriceOfItemGroup();
        this.shippingDate = setShippingDate();
    }

    private LocalDate setShippingDate() {
        if (item.getAmountInStock() - orderAmount > 0) {
           return LocalDate.now().plusDays(NEXT_DAY_DELIVERY);
        } return  LocalDate.now().plusDays(NEXT_WEEK_DELIVERY);
    }

    public double getPriceOfItemGroup() {
        return item.getPriceInEuro() * orderAmount;
    }

    public double getTotalPriceOfItemGroup() {
        return totalPriceOfItemGroup;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public Item getItem() {
        return item;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
