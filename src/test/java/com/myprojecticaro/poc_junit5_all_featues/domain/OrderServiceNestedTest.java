package com.myprojecticaro.poc_junit5_all_featues.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OrderService Tests")
class OrderServiceNestedTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Nested
    @DisplayName("When amount is invalid")
    class InvalidAmount {

        @Test
        @DisplayName("Should throw exception when amount is zero")
        void shouldThrowWhenZero() {
            assertThrows(IllegalArgumentException.class, () -> {
                orderService.processOrder(0);
            });
        }

        @Test
        @DisplayName("Should throw exception when amount is negative")
        void shouldThrowWhenNegative() {
            assertThrows(IllegalArgumentException.class, () -> {
                orderService.processOrder(-10);
            });
        }
    }

    @Nested
    @DisplayName("When amount is valid")
    class ValidAmount {

        @Test
        @DisplayName("Should return STANDARD for small orders")
        void shouldReturnStandard() {
            String result = orderService.processOrder(50);
            assertEquals("STANDARD", result);
        }

        @Test
        @DisplayName("Should return PREMIUM for medium orders")
        void shouldReturnPremium() {
            String result = orderService.processOrder(200);
            assertEquals("PREMIUM", result);
        }

        @Test
        @DisplayName("Should return VIP for large orders")
        void shouldReturnVip() {
            String result = orderService.processOrder(600);
            assertEquals("VIP", result);
        }
    }
}