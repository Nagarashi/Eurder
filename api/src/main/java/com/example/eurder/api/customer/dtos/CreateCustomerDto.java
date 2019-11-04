package com.example.eurder.api.customer.dtos;

public class CreateCustomerDto {

    private String firstName;
    private String lastName;
    private EmailDto email;
    private AddressDto address;
    private String phoneNumber;

    public CreateCustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateCustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateCustomerDto setEmail(EmailDto email) {
        this.email = email;
        return this;
    }

    public CreateCustomerDto setAddress(AddressDto addressDto) {
        this.address = addressDto;
        return this;
    }

    public CreateCustomerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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
