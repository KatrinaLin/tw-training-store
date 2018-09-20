package com.example.store.shoppingcarts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartProduct, Integer> {

}
