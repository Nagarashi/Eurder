package com.example.eurder.api.customer.dtos;

public class CustomerDto {

    private String id;
    private String firstName;
    private String lastName;
    private EmailDto email;
    private AddressDto address;
    private String phoneNumber;

    public CustomerDto setid(String id) {
        this.id = id;
        return this;
    }

    public CustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto setEmail(EmailDto email) {
        this.email = email;
        return this;
    }

    public CustomerDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public CustomerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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

    public EmailDto getEmail() {
        return email;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
