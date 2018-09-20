package com.example.store.shoppingcarts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartProduct> addToCart(List<CartProduct> cartProducts) {
//        List<CartProduct> cart = new ArrayList<>();
//
//        CartProduct cartProduct = new CartProduct();
//        cartProduct.setProductId(1);
//        cartProduct.setQuantity(3);
//        cart.add(cartProduct);
//
//        CartProduct cartProduct1 = new CartProduct();
//        cartProduct1.setProductId(2);
//        cartProduct1.setQuantity(4);
//        cart.add(cartProduct1);
//
//        return cart;

        return cartRepository.saveAll(cartProducts);
    }
}
