package com.myprojecticaro.poc_junit5_all_featues.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(LogExecutionTimeExtension.class)
class SampleTest {

    @Test
    void fastTest() throws Exception {
        Thread.sleep(100);
    }

    @Test
    void slowTest() throws Exception {
        Thread.sleep(300);
    }
}