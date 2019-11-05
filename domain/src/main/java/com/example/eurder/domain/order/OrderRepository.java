package com.example.eurder.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class OrderRepository {

    private Map<String, Order>  orders;

    @Autowired
    public OrderRepository() {
        this.orders = new ConcurrentHashMap<>();
    }

    public Order saveOrder(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public List<Order> getOrdersPerCustomer(String customerId) {
        return orders.values().stream()
                .filter(order -> order.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }
}
