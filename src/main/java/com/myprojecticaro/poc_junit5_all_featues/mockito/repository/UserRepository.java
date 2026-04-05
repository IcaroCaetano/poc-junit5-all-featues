package com.myprojecticaro.poc_junit5_all_featues.mockito.repository;

import com.myprojecticaro.poc_junit5_all_featues.mockito.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    User save(User user);

    void delete(User user);
}