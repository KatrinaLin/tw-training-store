package com.example.store.orders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
@ContextConfiguration()
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void should_create_order_when_post_order() {
        List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setProductId(1);
        orderProduct1.setOrderId(1);
        orderProduct1.setUserId(1);
        orderProduct1.setQuantity(3);

        orderProductList.add(orderProduct1);

        given(orderService.createOrder(orderProductList)).willReturn(new Order());
    }
}