package com.example.store.orders;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
@ContextConfiguration()
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void should_create_order_when_post_order() throws Exception {
        List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setProductId(1);
        orderProduct1.setQuantity(3);

        orderProductList.add(orderProduct1);

        String orderListJSON = JSONObject.toJSONString(orderProductList);

        given(orderService.createOrder(Mockito.anyList())).willReturn(new Order());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderListJSON))
                .andExpect(status().isOk());
    }
}