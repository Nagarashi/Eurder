package com.example.eurder.service.item;

import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void givenAnItem_whenAddingItemToRepository_thenItemIsSavedInRepository() {

        //given
        Item itemOne = new Item("itemOne", "descr", 100, 1);

        //when & then
        Mockito.when(itemRepository.addItem(itemOne)).thenReturn(itemOne);
        Assertions.assertThat(itemService.addItem(itemOne)).isEqualTo(itemOne);
    }

    @Test
    void givenAllItems_whenGettingAllItemsFromService_thenReturnAllItemsStoredInRepository() {
        //given
        List<Item> items = List.of(
                new Item("itemOne", "descr", 100, 1),
                new Item("itemOne", "descr", 100, 1)
        );

        //when & then
        Mockito.when(itemRepository.getAllItems()).thenReturn(items);
        Assertions.assertThat(itemService.getAllItems()).isEqualTo(items);
    }

}