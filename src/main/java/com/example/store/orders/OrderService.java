package com.example.store.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(List<OrderProduct> orderProductList) {

        Order order = new Order();
        order.setProductList(orderProductList);
        order.setStatus("UNPAID");

        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }
}
