package com.example.eurder.service.order;

import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Path2D;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Order> getOrdersByCustomer (String customerId) {
        return orderRepository.getOrdersPerCustomer(customerId);
    }

    public double getPriceOfOrdersPerCustomer(String customerId) {
        return orderRepository.getAllOrders().stream()
                .filter(order -> order.getCustomer().getId().equals(customerId))
                .map(Order::getTotalPrice)
                .reduce(0.0, Double::sum);
    }
}
