package com.example.store.shoppingCarts;

import com.example.store.shoppingcarts.CartProduct;
import com.example.store.shoppingcarts.CartRepository;
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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

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
    public void should_save_products_and_find_products() {
        List<CartProduct> cartProducts = getCartProducts();

        cartProducts.forEach(cartProduct -> testEntityManager.persist(cartProduct));

        List<CartProduct> cartInRepository = cartRepository.findAll();

        assertThat(cartInRepository.size(), is(2));
        assertThat(cartInRepository.get(0).getProductId(), is(1));
        assertThat(cartInRepository.get(1).getProductId(), is(2));
    }

    private List<CartProduct> getCartProducts() {
        List<CartProduct> cart = new ArrayList<>();

        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductId(1);
        cartProduct.setQuantity(3);
        cart.add(cartProduct);

        CartProduct cartProduct1 = new CartProduct();
        cartProduct1.setProductId(2);
        cartProduct1.setQuantity(4);
        cart.add(cartProduct1);
        return cart;
    }
}