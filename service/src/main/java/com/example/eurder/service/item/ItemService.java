package com.example.eurder.service.item;

import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item) { return itemRepository.addItem(item); }

    public List<Item> getAllItems() { return itemRepository.getAllItems(); }

    public Item getItemById (String id) { return itemRepository.getItemById(id); }
}
