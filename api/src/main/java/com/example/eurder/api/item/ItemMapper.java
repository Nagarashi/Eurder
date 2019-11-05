package com.example.eurder.api.item;

import com.example.eurder.api.item.dtos.ItemDto;
import com.example.eurder.api.order.dtos.reports.ItemReportDto;
import com.example.eurder.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto mapItemToDto(Item item) {
        return new ItemDto()
                .setId(item.getId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPriceInEuro(item.getPriceInEuro())
                .setAmountInStock(item.getAmountInStock());
    }

    public ItemReportDto mapItemReportToDto(Item item) {
        return new ItemReportDto()
                .setName(item.getName());
    }
}
