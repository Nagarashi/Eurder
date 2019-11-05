package com.example.eurder.domain.order;

import com.example.eurder.domain.item.Item;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemGroup {

    private String itemId;
    private int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemId, int amount, LocalDate shippingDate) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }
}
