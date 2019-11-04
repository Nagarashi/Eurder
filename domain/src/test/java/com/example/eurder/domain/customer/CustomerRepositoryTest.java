package com.example.eurder.domain.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerRepositoryTest {

    private Customer customer;
    private Address address;
    private Email email;
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepository();
        address = new Address("Frank Van Ackerpromeande", 6, "8000", "Brugge");
        email = new Email("kai.vanlandschoot", "@gmail.com");
        customer = new Customer("Kai", "Van Landschoot", email, address, "+32494151225");
        customerRepository.saveCustomer(customer);
    }

    @Test
    void givenMember_whenAddingMember_memberIsAddedToRepository() {
        Assertions.assertThat(customerRepository.getAllCustomers()).contains(customer);
    }

    @Test
    void givenCustomerRepositoryWithCustomers_whenGettingAllCustomers_returnAllCustomers() {
        Customer testCustomer1 = new Customer("Bobette", "de Vries", email, address, "+3212345678965");
        Customer testCustomer2 = new Customer("Tim", "de Leraar", email, address, "+3212345888865");
        Customer testCustomer3 = new Customer("Kai", "Van Landschoot", email, address, "+3212347777965");

        customerRepository.saveCustomer(testCustomer1);
        customerRepository.saveCustomer(testCustomer2);
        customerRepository.saveCustomer(testCustomer3);

        Assertions.assertThat(customerRepository.getAllCustomers()).contains(testCustomer1, testCustomer2, testCustomer3);
    }

}