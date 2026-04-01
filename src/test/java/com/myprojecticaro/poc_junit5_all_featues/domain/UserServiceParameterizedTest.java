package com.myprojecticaro.poc_junit5_all_featues.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceParameterizedTest {

    private final UserService userService = new UserService();

    @ParameterizedTest
    @ValueSource(strings = {"abc", "john123", "user01"})
    void shouldAcceptValidUsernames(String username) {
        assertTrue(userService.isValidUsername(username));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void shouldRejectInvalidUsernames(String username) {
        assertFalse(userService.isValidUsername(username));
    }

    @ParameterizedTest
    @CsvSource({
        "10, 10",
        "17, 10",
        "18, 0",
        "30, 0",
        "60, 20",
        "80, 20"
    })
    void shouldCalculateDiscount(int age, int expectedDiscount) {
        assertEquals(expectedDiscount, userService.calculateDiscount(age));
    }

    @ParameterizedTest
    @MethodSource("provideUserCategories")
    void shouldReturnCorrectCategory(int age, String expectedCategory) {
        assertEquals(expectedCategory, userService.getUserCategory(age));
    }

    static Stream<Arguments> provideUserCategories() {
        return Stream.of(
            Arguments.of(10, "MINOR"),
            Arguments.of(25, "ADULT"),
            Arguments.of(59, "ADULT"),
            Arguments.of(60, "SENIOR"),
            Arguments.of(90, "SENIOR")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void shouldThrowExceptionForInvalidAge(int age) {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.calculateDiscount(age);
        });
    }
}