package com.example.store.orders;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    public Order createOrder(List<OrderProduct> orderProductList) {

        Order order = new Order();
        order.setProductList(orderProductList);
        order.setStatus("UNPAID");

        return order;
    }
}
