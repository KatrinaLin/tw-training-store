package com.example.store.orders;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrdersIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Flyway flyway;

    @Before
    public void setUp() throws Exception {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void should_create_order_when_post_order() {
        List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setProductId(1);
        orderProduct1.setOrderId(1);
        orderProduct1.setUserId(1);
        orderProduct1.setQuantity(3);

        orderProductList.add(orderProduct1);

        ResponseEntity<Void> orderEntity = restTemplate.postForEntity(
                "/api/users/1/orders", orderProductList, Void.class
        );

        assertThat(orderEntity.getStatusCode(), is(HttpStatus.OK));

//        ResponseEntity<Order> responseEntity = restTemplate.getForEntity(
//                "/api/users/1/orders/1", Order.class);
//        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
//        OrderProduct actualOrderProduct = orderEntity.getBody()[0];
//        assertThat(actualOrderProduct.getUserId(), is(1));
    }
}
