package com.example.store.shoppingCarts;

import com.example.store.products.Product;
import com.example.store.shoppingcarts.CartProduct;
import com.example.store.shoppingcarts.CartRepository;
import com.example.store.shoppingcarts.CartService;
import org.assertj.core.util.Lists;
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
public class CartServiceTest {
    @InjectMocks
    private CartService cartService;
    
    @Mock
    private CartRepository cartRepository;

    @Test
    public void should_add_cart_when_post_cart() {
        List<CartProduct> cart = getCartProducts();

        given(cartRepository.saveAll(cart)).willReturn(cart);

        List<CartProduct> cartProductList = cartService.addToCart(cart);
        assertThat(cartProductList.size(), is(2));
        assertThat(cartProductList.get(0).getProductId(), is(1));
        assertThat(cartProductList.get(0).getQuantity(), is(3));
        assertThat(cartProductList.get(1).getProductId(), is(2));
        assertThat(cartProductList.get(1).getQuantity(), is(4));
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