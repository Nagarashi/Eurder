package com.example.eurder.api.order;

import com.example.eurder.api.customer.CustomerMapper;
import com.example.eurder.api.item.ItemMapper;
import com.example.eurder.api.order.dtos.ItemGroupDto;
import com.example.eurder.api.order.dtos.OrderDto;
import com.example.eurder.domain.order.ItemGroup;
import com.example.eurder.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private CustomerMapper customerMapper;
    private ItemMapper itemMapper;

    @Autowired
    public OrderMapper(CustomerMapper customerMapper, ItemMapper itemMapper) {
        this.customerMapper = customerMapper;
        this.itemMapper = itemMapper;
    }

    public OrderDto mapOrderToDto(Order order) {
        return new OrderDto()
                .setId(order.getId())
                .setCustomerDto(customerMapper.mapCustomerToDto(order.getCustomer()))
                .setItemGroupList(order.getItemGroupList().stream()
                        .map(this::mapItemGroupToDto)
                        .collect(Collectors.toList()))
                .setTotalOrderPrice(order.getTotalPrice());
    }

    private ItemGroupDto mapItemGroupToDto(ItemGroup itemGroup) {
        return new ItemGroupDto()
                .setItem(itemMapper.mapItemToDto(itemGroup.getItem()))
                .setOrderAmount(itemGroup.getOrderAmount())
                .setTotalPrice(itemGroup.getTotalPriceOfItemGroup())
                .setShippingDate(itemGroup.getShippingDate());
    }
}
