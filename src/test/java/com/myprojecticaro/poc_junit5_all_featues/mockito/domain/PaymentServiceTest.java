package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    @Test
    @Tag("unit")
    @Tag("fast")
    void shouldCalculateTotal() {}

    @Test
    @Tag("integration")
    @Tag("slow")
    void shouldCallExternalAPI() {}
}