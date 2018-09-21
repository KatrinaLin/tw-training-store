package com.example.store.orders;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private Flyway flyway;

    @Before
    public void setUp() throws Exception {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void should_save_order_and_order_products() {
        List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setProductId(1);
        orderProduct1.setQuantity(3);

        orderProductList.add(orderProduct1);

        OrderProduct orderProduct2 = new OrderProduct();
        orderProduct2.setProductId(1);
        orderProduct2.setQuantity(3);

        orderProductList.add(orderProduct2);

        Order order = new Order();
        order.setOrderId(1);
        order.setProductList(orderProductList);

//        orderProductList.forEach(orderProduct -> testEntityManager.persist(orderProduct));
        testEntityManager.persist(order);

        Order repoOrder = orderRepository.findById(1).orElse(new Order());

        assertThat(repoOrder.getProductList().size(), is(2));
    }
}