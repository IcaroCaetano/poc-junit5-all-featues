package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomServiceTest {

    RandomService service = new RandomService();

    @RepeatedTest(10)
    void shouldGenerateNumberBetween0And9() {

        int value = service.generate();

        assertTrue(value >= 0 && value < 10);
    }
}