package com.myprojecticaro.poc_junit5_all_featues.domain;


public class UserService {

    public boolean isValidUsername(String username) {
        if (username == null || username.isBlank()) {
            return false;
        }
        return username.length() >= 3 && username.length() <= 10;
    }

    public int calculateDiscount(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        if (age < 18) {
            return 10;
        } else if (age >= 60) {
            return 20;
        }
        return 0;
    }

    public String getUserCategory(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        if (age < 18) return "MINOR";
        if (age < 60) return "ADULT";
        return "SENIOR";
    }
}