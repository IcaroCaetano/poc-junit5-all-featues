package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import com.myprojecticaro.poc_junit5_all_featues.mockito.repository.OrderRepository;
import com.myprojecticaro.poc_junit5_all_featues.mockito.model.Order;

class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void createOrder(double amount) {
        Order order = new Order("CREATED", amount);
        repository.save(order);
    }
}