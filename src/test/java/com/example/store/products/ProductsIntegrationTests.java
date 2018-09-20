package com.example.store.products;

import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductsIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    Flyway flyway;

    @Before
    public void setUp() throws Exception {
        flyway.clean();
        flyway.migrate();
    }

    @After
    public void tearDown() throws Exception {
        flyway.clean();
    }

    @Test
    public void should_return_product_lists_when_call_get_products_list() {
        ResponseEntity<List<Product>> productsEntity = restTemplate.exchange
                ("/api/products", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
        });
        assertThat(productsEntity.getStatusCode(), is(HttpStatus.OK));

        List<Product> products = productsEntity.getBody();

        Product product = products.get(0);
        assertThat(product.getName(), is("Coke"));
        assertThat(product.getPrice(), is(BigDecimal.valueOf(4.5)));
        assertThat(product.getUnit(), is("bottle"));
        assertThat(product.getTotalAmount(), is(10));
        assertThat(product.getImgUrl(), is("/api/img/1"));
    }
}
