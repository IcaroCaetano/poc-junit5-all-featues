package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import com.myprojecticaro.poc_junit5_all_featues.mockito.model.User;
import com.myprojecticaro.poc_junit5_all_featues.mockito.repository.UserRepository;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(String email) {

        repository.findByEmail(email)
            .ifPresent(user -> {
                throw new IllegalArgumentException("User already exists");
            });

        User user = new User(email);
        return repository.save(user);
    }
}