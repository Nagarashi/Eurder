package com.example.eurder.api.item;

import com.example.eurder.api.item.dtos.CreateItemDto;
import com.example.eurder.api.item.dtos.ItemDto;
import com.example.eurder.domain.item.Item;
import com.example.eurder.service.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("eurder/items")
public class ItemController {

    private Logger logger = LoggerFactory.getLogger(ItemController.class);
    private ItemService itemService;
    private ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getALlItems() {
        logger.info("GET request for all items");
        return itemService.getAllItems().stream()
                .map(item -> itemMapper.mapItemToDto(item))
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto createItemDto) {
        logger.info("POST request for a single item");
        return itemMapper.mapItemToDto(
                itemService.addItem(
                        new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPriceInEuro(), createItemDto.getAmountInStock()))
        );
    }
}
