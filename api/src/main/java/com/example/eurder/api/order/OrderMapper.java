package com.example.eurder.api.order;

import com.example.eurder.api.customer.CustomerMapper;
import com.example.eurder.api.item.ItemMapper;
import com.example.eurder.api.order.dtos.ItemGroupDto;
import com.example.eurder.api.order.dtos.reports.ItemGroupReportDto;
import com.example.eurder.api.order.dtos.OrderDto;
import com.example.eurder.api.order.dtos.reports.MultipleOrdersReportDto;
import com.example.eurder.api.order.dtos.reports.SingleOrderReportDto;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.order.ItemGroup;
import com.example.eurder.domain.order.Order;
import com.example.eurder.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private CustomerMapper customerMapper;
    private ItemMapper itemMapper;
    private OrderService orderService;

    @Autowired
    public OrderMapper(CustomerMapper customerMapper, ItemMapper itemMapper, OrderService orderService) {
        this.customerMapper = customerMapper;
        this.itemMapper = itemMapper;
        this.orderService = orderService;
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

    public MultipleOrdersReportDto mapOrdersReportToDto(List<Order> orders) {
        return new MultipleOrdersReportDto()
                .setTotalPriceOfAllOrders(orders.stream()
                        .map(Order::getTotalPrice)
                        .reduce(0.0, Double::sum))
                .setOrders(orders.stream()
                        .map(this::mapSingleOrderReportToDto)
                        .collect(Collectors.toList()));
    }

    private SingleOrderReportDto mapSingleOrderReportToDto(Order order) {
        return new SingleOrderReportDto()
                .setOrderId(order.getId())
                .setItemGroups(order.getItemGroupList().stream()
                        .map(this::mapItemGroupReportDto)
                        .collect(Collectors.toList()))
                .setTotalOrderPrice(order.getTotalPrice());
    }

    private ItemGroupReportDto mapItemGroupReportDto(ItemGroup itemGroup) {
        return new ItemGroupReportDto()
                .setItemReport(itemMapper.mapItemReportToDto(itemGroup.getItem()))
                .setAmountOrdered(itemGroup.getOrderAmount())
                .setTotalPriceOfItemGroup(itemGroup.getTotalPriceOfItemGroup());
    }
}
