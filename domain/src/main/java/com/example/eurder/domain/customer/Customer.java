package com.example.eurder.domain.customer;

import java.util.UUID;

public class Customer {

    private final String id;
    private String firstName;
    private String lastName;
    private Email email;
    private Address address;
    private String phoneNumber;

    public Customer(String firstName, String lastName, Email email, Address address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
