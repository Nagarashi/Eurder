package com.example.eurder.api.customer;

import com.example.eurder.api.customer.dtos.AddressDto;
import com.example.eurder.api.customer.dtos.CreateCustomerDto;
import com.example.eurder.api.customer.dtos.CustomerDto;
import com.example.eurder.api.customer.dtos.EmailDto;
import com.example.eurder.domain.customer.Address;
import com.example.eurder.domain.customer.Email;
import com.example.eurder.service.customer.CustomerService;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.CheckReturnValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.http.ContentType.JSON;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
class CustomerControllerTest {

    @Value("${server.port}")
    private int port;

    @Test
    void givenACustomer_whenPostCustomer_thenCustomerIsAddedToRepository() {
        AddressDto addressDto = new AddressDto()
                .setStreet("Frank Van Ackerpromeande")
                .setHouseNumber(6)
                .setZipCode("8000")
                .setCity("Brugge");

        EmailDto emailDto = new EmailDto()
                .setAddress("kai.vanlandschoot")
                .setDomain("@gmail.com");

        CreateCustomerDto newCustomer = new CreateCustomerDto()
                .setFirstName("Kai")
                .setLastName("Van Landschoot")
                .setAddress(addressDto)
                .setEmail(emailDto)
                .setPhoneNumber("+32494151225");

        CustomerDto postedCustomer = RestAssured
                .given()
                .body(newCustomer)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/eurder/customers")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(CustomerDto.class);

        Assertions.assertThat(postedCustomer.getId()).isNotBlank();
        Assertions.assertThat(postedCustomer.getFirstName()).isEqualTo(newCustomer.getFirstName());
        Assertions.assertThat(postedCustomer.getLastName()).isEqualTo(newCustomer.getLastName());
        Assertions.assertThat(postedCustomer.getPhoneNumber()).isEqualTo(newCustomer.getPhoneNumber());
        Assertions.assertThat(postedCustomer.getAddress()).isEqualToComparingFieldByField(newCustomer.getAddress());
        Assertions.assertThat(postedCustomer.getEmail()).isEqualToComparingFieldByField(newCustomer.getEmail());

    }
}