package com.example.eurder.domain.customer;

public class Email {

    private String address;
    private String domain;

    public Email(String address, String domain) {
        this.address = address;
        this.domain = domain;
    }

    public String getAddress() {
        return address;
    }

    public String getDomain() {
        return domain;
    }
}
