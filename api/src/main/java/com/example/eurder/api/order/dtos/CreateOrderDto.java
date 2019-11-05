package com.example.eurder.api.order.dtos;

import com.example.eurder.api.customer.dtos.CustomerDto;
import com.example.eurder.domain.order.ItemGroup;

import java.util.List;

public class CreateOrderDto {

    private List<CreateItemGroupDto> itemGroupList;
    private CustomerDto customer;

    public CreateOrderDto setItemGroupList(List<CreateItemGroupDto> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public CreateOrderDto setCustomerDto(CustomerDto customer) {
        this.customer = customer;
        return this;
    }

    public List<CreateItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }

    public CustomerDto getCustomerDto() {
        return customer;
    }
}
