package com.example.store.shoppingcarts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartsController {

    @Autowired
    private CartService cartService;

    @PostMapping("/api/users/1/shoppingcarts")
    public List<CartProduct> addToCart(@RequestBody List<CartProduct> productsInCart) {

        return cartService.addToCart(productsInCart);
    }

}
