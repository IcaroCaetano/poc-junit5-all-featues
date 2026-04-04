package com.myprojecticaro.poc_junit5_all_featues.mockito.model;

public class Order {
    String status;
    double amount;

    public Order(String status, double amount) {
        this.status = status;
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}