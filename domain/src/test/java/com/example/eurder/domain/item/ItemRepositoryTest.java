package com.example.eurder.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    private Item item;
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        itemRepository = new ItemRepository();
        item = new Item("itemOne", "descr", 100.0, 5);
        itemRepository.addItem(item);
    }

    @Test
    void givenItem_whenAddingItem_ItemIsAddedToRepository() {
        Assertions.assertThat(itemRepository.getAllItems()).contains(item);
    }

    @Test
    void givenItemRepositoryWithItems_whenGettingAllItems_returnAllItems() {
        Item testItem1 = new Item("testItemOne", "description", 1.1, 1);
        Item testItem2 = new Item("TestItemFour", "description", 10, 2);
        Item testItem3 = new Item("testItemThree", "description0", 50.5, 3);

        itemRepository.addItem(testItem1);
        itemRepository.addItem(testItem2);
        itemRepository.addItem(testItem3);

        Assertions.assertThat(itemRepository.getAllItems()).contains(testItem1, testItem2, testItem3);
    }

}