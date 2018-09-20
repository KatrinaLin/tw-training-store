package com.example.store.shoppingCarts;

import com.example.store.shoppingcarts.CartProduct;
import com.mysql.cj.xdevapi.JsonArray;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingCartsIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_add_items_to_shopping_cart_when_call_post_shopping_cart() {
        List<CartProduct> cart = new ArrayList<>();
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductId(1);
        cartProduct.setQuantity(3);

        cart.add(cartProduct);

//        ResponseEntity<Void> cartEntity= restTemplate.postForEntity(
//                "/api/users/1/shoppingcarts", cart, Void.class);
//        assertThat(cartEntity.getStatusCode(), is(HttpStatus.OK));

        ResponseEntity<CartProduct[]> cartEntity= restTemplate.postForEntity(
                "/api/users/1/shoppingcarts", cart, CartProduct[].class);
        assertThat(cartEntity.getStatusCode(), is(HttpStatus.OK));

        CartProduct actualCartProduct = cartEntity.getBody()[0];
        assertThat(actualCartProduct.getProductId(), is(1));
        assertThat(actualCartProduct.getQuantity(), is(3));
    }
}
