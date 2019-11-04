package com.example.eurder.domain.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class CustomerRepository {

    private Map<String, Customer> customers;
    private Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerRepository() {
        this.customers = new ConcurrentHashMap<>();
        customers.put(UUID.randomUUID().toString() , new Customer("Kai", "Van Landschoot",
                new Email("kai.vanlandschoot", "@gmail.com"),
                new Address("Frank Van Ackerpromeande", 6, "8000", "Brugge"),
                "+32494151225"));
    }

    public Customer saveCustomer (Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomerById(String id) throws IllegalArgumentException {
        Customer customer = customers.get(id);
        if (customer == null) {
            logger.error("invalid GET call, customer with given id does not exist");
            throw new IllegalArgumentException("Couldn't find customer with id " + id);
        }
        return customers.get(id);
    }
}
