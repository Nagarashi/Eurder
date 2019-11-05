package com.example.eurder.api.item;

import com.example.eurder.api.Application;
import com.example.eurder.api.item.dtos.CreateItemDto;
import com.example.eurder.api.item.dtos.ItemDto;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemRepository;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.http.ContentType.JSON;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
class ItemControllerTest {

    @Value("${server.port}")
    private int port;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void givenListOfItems_whenGettingAllItems_returnsAllItemssInRepository() {

        RestAssured
                .given()
                .contentType(JSON)
                .when()
                .port(port)
                .get("/eurder/items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .body()
                .jsonPath().getList(".", ItemDto.class);
    }

    @Test
    void givenAnItem_whenPostItem_thenItemIsAddedToRepository() {
        CreateItemDto testItemDto = new CreateItemDto()
                .setName("testItem")
                .setDescription("Description")
                .setPriceInEuro(100.0)
                .setAmountInStock(10);

        ItemDto postedItem =  RestAssured
                .given()
                .body(testItemDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/eurder/items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ItemDto.class);

        Assertions.assertThat(postedItem.getId()).isNotBlank();
        Assertions.assertThat(postedItem.getName()).isEqualTo(testItemDto.getName());
        Assertions.assertThat(postedItem.getDescription()).isEqualTo(testItemDto.getDescription());
        Assertions.assertThat(postedItem.getPriceInEuro()).isEqualTo(testItemDto.getPriceInEuro());
        Assertions.assertThat(postedItem.getAmountInStock()).isEqualToComparingFieldByField(testItemDto.getAmountInStock());
    }
}