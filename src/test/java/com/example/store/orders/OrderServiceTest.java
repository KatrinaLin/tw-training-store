package com.example.store.orders;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    @Ignore
    public void should_create_order_when_post_order_product_list() {
        List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setProductId(1);
        orderProduct1.setQuantity(3);

        orderProductList.add(orderProduct1);

        Order order = new Order();
        order.setProductList(orderProductList);

        given(orderRepository.save(order)).willReturn(order);

        Order actualOrder = orderService.createOrder(orderProductList);

        assertArrayEquals(actualOrder.getProductList().toArray(), orderProductList.toArray());
    }
}