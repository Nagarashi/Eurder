package com.example.eurder.domain.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemRepository {

    private List<Item> items;

    @Autowired
    public ItemRepository() {
        this.items = new ArrayList<>();
    }

    public Item addItem(Item item) {
        items.add(item);
        return item;
    }

    public List<Item> getAllItems() {
        return items;
    }
}
