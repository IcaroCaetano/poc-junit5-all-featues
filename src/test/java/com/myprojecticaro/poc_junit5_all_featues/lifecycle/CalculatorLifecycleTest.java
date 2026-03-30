package com.myprojecticaro.poc_junit5_all_featues.lifecycle;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class CalculatorLifecycleTest {

    private Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before ALL tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before EACH test");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After EACH test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After ALL tests");
    }

    @Test
    @DisplayName("Should sum two numbers")
    void shouldSumTwoNumbers() {
        int result = calculator.sum(2, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("Should throw exception when dividing by zero")
    void shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}