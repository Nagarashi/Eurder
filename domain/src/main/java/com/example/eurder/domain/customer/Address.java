package com.example.eurder.domain.customer;

public class Address {

    private String street;
    private int houseNumber;
    private String zipCode;
    private String City;

    public Address(String street, int houseNumber, String zipCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        City = city;
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
