package com.example.eurder.api.order;

import com.example.eurder.api.order.dtos.CreateOrderDto;
import com.example.eurder.api.order.dtos.OrderDto;
import com.example.eurder.api.order.dtos.reports.MultipleOrdersReportDto;
import com.example.eurder.api.order.dtos.reports.SingleOrderReportDto;
import com.example.eurder.domain.order.ItemGroup;
import com.example.eurder.domain.order.Order;
import com.example.eurder.service.customer.CustomerService;
import com.example.eurder.service.item.ItemService;
import com.example.eurder.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("eurder/orders")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);
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
        logger.info("GET request for all orders");
        return orderService.getAllOrders().stream()
                .map(order -> orderMapper.mapOrderToDto(order))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/customer/{customerId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public MultipleOrdersReportDto getOrdersPerCustomer(@PathVariable String customerId) {
        return orderMapper.mapOrdersReportToDto(
                orderService.getOrdersByCustomer(customerId)
        );
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody CreateOrderDto createOrderDto) {
        logger.info("POST request for a single order");
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
