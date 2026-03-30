package com.myprojecticaro.poc_junit5_all_featues.lifecycle;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default
class CalculatorLifecycleTest {

    private Calculator calculator;

    // Executa uma vez antes de TODOS os testes
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Before ALL tests");
    }

    // Executa antes de CADA teste
    @BeforeEach
    void setUp() {
        System.out.println(">>> Before EACH test");
        calculator = new Calculator();
    }

    // Executa depois de CADA teste
    @AfterEach
    void tearDown() {
        System.out.println(">>> After EACH test");
    }

    // Executa uma vez depois de TODOS os testes
    @AfterAll
    static void afterAll() {
        System.out.println(">>> After ALL tests");
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