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

        return cartRepository.saveAll(cartProducts);
    }
}
