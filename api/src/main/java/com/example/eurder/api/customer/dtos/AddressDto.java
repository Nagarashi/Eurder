package com.example.eurder.api.customer.dtos;

public class AddressDto {

    private String street;
    private int houseNumber;
    private String zipCode;
    private String City;

    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressDto setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressDto setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressDto setCity(String city) {
        City = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return City;
    }
}
