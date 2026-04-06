package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomServiceTest {

    RandomService service = new RandomService();

    @RepeatedTest(10)
    void shouldGenerateNumberBetween0And9() {

        int value = service.generate();

        assertTrue(value >= 0 && value < 10);
    }

    @RepeatedTest(3)
    void shouldShowRepetitionInfo(RepetitionInfo info) {

        System.out.println("Current: " + info.getCurrentRepetition());
        System.out.println("Total: " + info.getTotalRepetitions());
    }
}