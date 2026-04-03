package com.myprojecticaro.poc_junit5_all_featues.domain;

import com.myprojecticaro.poc_junit5_all_featues.model.User;

import java.util.List;

public class UserAdminService {

    public User createUser(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        List<String> roles = age >= 18
                ? List.of("USER")
                : List.of("USER", "MINOR");

        return new User(name, age, roles);
    }

    public void simulateSlowProcess() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
