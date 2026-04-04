package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import com.myprojecticaro.poc_junit5_all_featues.mockito.model.Order;
import com.myprojecticaro.poc_junit5_all_featues.mockito.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository repository;

    @Test
    void shouldSaveOrderWithCorrectData() {

        orderService.createOrder(200);

        ArgumentCaptor<Order> captor = ArgumentCaptor.forClass(Order.class);

        verify(repository).save(captor.capture());

        Order order = captor.getValue();

        assertAll(
                () -> assertEquals("CREATED", order.getStatus()),
                () -> assertEquals(200, order.getAmount())
        );
    }

}
