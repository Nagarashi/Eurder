package com.example.eurder.domain.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ItemRepository {

    private Map<String, Item> items;

    @Autowired
    public ItemRepository() {
        this.items = new ConcurrentHashMap<>();
    }

    public Item addItem(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public Item getItemById(String id) throws IllegalArgumentException {
        Item customer = items.get(id);
        if (customer == null) {
            throw new IllegalArgumentException("Couldn't find customer with id " + id);
        }
        return items.get(id);
    }
}
