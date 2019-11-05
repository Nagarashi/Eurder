package com.example.eurder.api.order.dtos.reports;

public class ItemGroupReportDto {

    private ItemReportDto itemReport;
    private int amountOrdered;
    private double totalPriceOfItemGroup;

    public ItemGroupReportDto setTotalPriceOfItemGroup(double totalPriceOfItemGroup) {
        this.totalPriceOfItemGroup = totalPriceOfItemGroup;
        return this;
    }

    public ItemGroupReportDto setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
        return this;
    }

    public ItemGroupReportDto setItemReport(ItemReportDto itemReport) {
        this.itemReport = itemReport;
        return this;
    }

    public double getTotalPriceOfItemGroup() {
        return totalPriceOfItemGroup;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public ItemReportDto getItemReport() {
        return itemReport;
    }
}
