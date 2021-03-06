package com.example.store.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/users/1/orders")
    public Order createOrder(@RequestBody List<OrderProduct> orderProductList) {
        return orderService.createOrder(orderProductList);
    }
}
