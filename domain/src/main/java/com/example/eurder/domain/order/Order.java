package com.example.eurder.domain.order;

import com.example.eurder.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final String id;
    private List<ItemGroup> itemGroupList;
    private final Customer customer;

    public Order(List<ItemGroup> itemGroupList, Customer customer) {
        this.id = UUID.randomUUID().toString();
        this.itemGroupList = itemGroupList;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public Double getTotalPrice() {
        return itemGroupList.stream()
                .map(ItemGroup::getPriceOfItemGroup)
                .reduce(0.0, Double::sum);
    }

    public Customer getCustomer() {
        return customer;
    }


}
