package com.example.eurder.api.customer.dtos;

public class CustomerDto {

    private String firstName;
    private String lastName;
    private EmailDto emailDto;
    private AddressDto addressDto;
    private String phoneNumber;

    public CustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto setEmailDto(EmailDto emailDto) {
        this.emailDto = emailDto;
        return this;
    }

    public CustomerDto setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public CustomerDto setPhoneNumber(String phoneNumber) {
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
        return emailDto;
    }

    public AddressDto getAddress() {
        return addressDto;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
