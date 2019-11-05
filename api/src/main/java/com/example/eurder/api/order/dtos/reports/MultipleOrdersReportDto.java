package com.example.eurder.api.order.dtos.reports;

import java.util.List;

public class MultipleOrdersReportDto {

    private List<SingleOrderReportDto> orders;
    private double totalPriceOfAllOrders;

    public MultipleOrdersReportDto setOrders(List<SingleOrderReportDto> orders) {
        this.orders = orders;
        return this;
    }

    public MultipleOrdersReportDto setTotalPriceOfAllOrders(double totalPriceOfAllOrders) {
        this.totalPriceOfAllOrders = totalPriceOfAllOrders;
        return this;
    }

    public List<SingleOrderReportDto> getOrders() {
        return orders;
    }

    public double getTotalPriceOfAllOrders() {
        return totalPriceOfAllOrders;
    }
}
