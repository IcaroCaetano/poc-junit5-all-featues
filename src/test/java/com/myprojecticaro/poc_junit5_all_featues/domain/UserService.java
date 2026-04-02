package com.myprojecticaro.poc_junit5_all_featues.domain;

public class UserService {

    public boolean createUser(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Invalid username");
        }
        return true;
    }
}