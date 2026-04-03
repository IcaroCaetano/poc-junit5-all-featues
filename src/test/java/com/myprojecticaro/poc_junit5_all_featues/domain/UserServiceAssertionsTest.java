package com.myprojecticaro.poc_junit5_all_featues.domain;

import com.myprojecticaro.poc_junit5_all_featues.model.User;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceAssertionsTest {

    private final UserAdminService userService = new UserAdminService();

    @Test
    void shouldCreateValidUser() {

        User user = userService.createUser("John", 25);

        assertAll("User validation",
            () -> assertEquals("John", user.getName()),
            () -> assertTrue(user.getAge() > 18),
            () -> assertIterableEquals(List.of("USER"), user.getRoles())
        );
    }

    @Test
    void shouldThrowExceptionWhenNameIsInvalid() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser("", 20);
        });

        assertEquals("Name cannot be empty", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAgeIsInvalid() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser("John", -1);
        });

        assertEquals("Invalid age", ex.getMessage());
    }

    @Test
    void shouldNotThrowExceptionForValidInput() {
        assertDoesNotThrow(() -> {
            userService.createUser("Anna", 30);
        });
    }

    @Test
    void shouldExecuteWithinTime() {

        assertTimeout(Duration.ofSeconds(1), () -> {
            userService.simulateSlowProcess();
        });
    }

    @Test
    void shouldAssignCorrectRolesForMinor() {

        User user = userService.createUser("Mike", 15);

        assertIterableEquals(
            List.of("USER", "MINOR"),
            user.getRoles()
        );
    }

    @Test
    void shouldMatchOutputLines() {

        List<String> expected = List.of("User: .*", "Age: .*");
        List<String> actual = List.of("User: John", "Age: 25");

        assertLinesMatch(expected, actual);
    }
}