package com.example.eurder.service.customer;

import com.example.eurder.domain.customer.Address;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.CustomerRepository;
import com.example.eurder.domain.customer.Email;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    private Address address;
    private Email email;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        initMocks(this);
        address = new Address("Frank Van Ackerpromeande", 6, "8000", "Brugge");
        email = new Email("kai.vanlandschoot", "@gmail.com");
    }

    @Test
    void givenACustomer_whenAddingCustomerToRepository_thenCustomerIsSavedInRepository() {

        //given
        Customer customer1 = new Customer("Kai", "Van Landschoot", email, address, "+32494151225");

        //when & then
        Mockito.when(customerRepository.saveCustomer(customer1)).thenReturn(customer1);
        Assertions.assertThat(customerService.addCustomer(customer1)).isEqualTo(customer1);
    }

    @Test
    void givenAllCustomers_whenGettingAllCustomersFromService_thenReturnAllCustomersStoredInRepository() {
        //given
        List<Customer> customers = List.of(
                new Customer("Kai", "Van Landschoot", email, address, "+32494151225"),
                new Customer("Kai2", "Van Landschoot", email, address, "+32494151225")
        );

        //when & then
        Mockito.when(customerRepository.getAllCustomers()).thenReturn(customers);
        Assertions.assertThat(customerService.getAllCustomers()).isEqualTo(customers);
    }
}