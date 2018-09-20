package com.example.store.products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    @Autowired 
    private ProductRepository productRepository;
    
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void should_query_all_products_from_database() {
        Product product = new Product();
        product.setId(11);
        product.setName("可乐");
        product.setPrice(BigDecimal.valueOf(4.5));
        product.setUnit("瓶");
        product.setTotalAmount(10);
        product.setImgUrl("/api/img/1");
        testEntityManager.persist(product);

        Product product1 = new Product();
        product1.setId(12);
        product1.setName("雪碧");
        product1.setPrice(BigDecimal.valueOf(4.5));
        product1.setUnit("瓶");
        product1.setTotalAmount(10);
        product1.setImgUrl("/api/img/2");
        testEntityManager.persist(product1);

        List<Product> products = productRepository.findAll();

        assertThat(products.size(), is(3));
        assertThat(products.get(1).getName(), is("可乐"));
        assertThat(products.get(2).getName(), is("雪碧"));
    }
}