package com.example.eurder.api.order.dtos;


import com.example.eurder.api.customer.dtos.CustomerDto;

import java.util.List;

public class OrderDto {

    private String id;
    private List<ItemGroupDto> itemGroupList;
    private CustomerDto customer;
    private double totalPrice;

    public OrderDto setId(String id) {
        this.id = id;
        return this;
    }

    public OrderDto setItemGroupList(List<ItemGroupDto> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public OrderDto setCustomerDto(CustomerDto customer) {
        this.customer = customer;
        return this;
    }

    public OrderDto setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public String getId() {
        return id;
    }

    public List<ItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }

    public CustomerDto getCustomerDto() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
