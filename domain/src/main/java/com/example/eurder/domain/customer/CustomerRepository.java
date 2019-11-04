package com.example.eurder.domain.customer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepository {

    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
        customers.add(new Customer("Kai", "Van Landschoot",
                new Email("kai.vanlandschoot", "@gmail.com"),
                new Address("Frank Van Ackerpromeande", 6, "8000", "Brugge"),
                "+32494151225"));
    }

    public Customer saveCustomer (Customer customer) {
        customers.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
