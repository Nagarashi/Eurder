package com.example.eurder.api.order.dtos.reports;

import java.util.List;

public class SingleOrderReportDto {

    private String orderId;
    private List<ItemGroupReportDto> itemGroups;
    private double totalOrderPrice;

    public SingleOrderReportDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public SingleOrderReportDto setItemGroups(List<ItemGroupReportDto> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public SingleOrderReportDto setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<ItemGroupReportDto> getItemGroups() {
        return itemGroups;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
