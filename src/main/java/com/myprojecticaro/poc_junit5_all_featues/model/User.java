package com.myprojecticaro.poc_junit5_all_featues.model;

import java.util.List;

public class User {

    private String name;
    private int age;
    private List<String> roles;

    public User(String name, int age, List<String> roles) {
        this.name = name;
        this.age = age;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getRoles() {
        return roles;
    }
}