package com.myprojecticaro.poc_junit5_all_featues.domain;

public class OrderService {

    public String processOrder(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        if (amount < 100) {
            return "STANDARD";
        } else if (amount < 500) {
            return "PREMIUM";
        } else {
            return "VIP";
        }
    }
}