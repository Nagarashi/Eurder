package com.example.eurder.api.customer.dtos;

public class EmailDto {

    private String address;
    private String domain;

    public EmailDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmailDto setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public String getDomain() {
        return domain;
    }


}
