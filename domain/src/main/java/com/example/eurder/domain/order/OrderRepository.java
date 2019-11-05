package com.example.eurder.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
}
