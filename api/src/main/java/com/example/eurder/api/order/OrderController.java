package com.example.eurder.api.order;

import com.example.eurder.api.order.dtos.CreateOrderDto;
import com.example.eurder.api.order.dtos.OrderDto;
import com.example.eurder.domain.order.ItemGroup;
import com.example.eurder.domain.order.Order;
import com.example.eurder.service.customer.CustomerService;
import com.example.eurder.service.item.ItemService;
import com.example.eurder.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("eurder/orders")
public class OrderController {

    private OrderService orderService;
    private CustomerService customerService;
    private ItemService itemService;
    private OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService, ItemService itemService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.itemService = itemService;
        this.orderMapper = orderMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders().stream()
                .map(order -> orderMapper.mapOrderToDto(order))
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody CreateOrderDto createOrderDto) {
        return orderMapper.mapOrderToDto(
                orderService.saveOrder(new Order(
                        getItemGroup(createOrderDto),
                        customerService.getCustomerById(createOrderDto.getCustomer().getId()))));
    }

    private List<ItemGroup> getItemGroup(@RequestBody CreateOrderDto createOrderDto) {
        List<ItemGroup> itemGroups = createOrderDto.getItemGroupList()
                .stream()
        .map(createItemGroupDto -> new ItemGroup(itemService.getItemById(createItemGroupDto.getItem().getId()), createItemGroupDto.getOrderAmount()))
        .collect(Collectors.toList());
        itemGroups.stream()
                .forEach(itemGroup -> itemService.getItemById(itemGroup.getItem().getId()).setItemsInStock(itemGroup.getOrderAmount()));

        return itemGroups;
    }
}
