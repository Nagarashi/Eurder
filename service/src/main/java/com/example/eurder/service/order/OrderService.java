package com.example.eurder.service.order;

import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) { return orderRepository.saveOrder(order); }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
