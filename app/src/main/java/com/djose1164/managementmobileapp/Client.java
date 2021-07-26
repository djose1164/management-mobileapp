package com.djose1164.managementmobileapp;

import java.security.InvalidParameterException;

public class Client {
    private String name;
    private String address;
    private String phone_number;
    private String request;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        if (address.isEmpty())
            throw new InvalidParameterException("This field can't be empty");
        this.address = address;
    }
}
