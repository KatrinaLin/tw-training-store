package com.example.store.orders;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public Order createOrder(List<OrderProduct> orderProductList) {

        return new Order();
    }
}
