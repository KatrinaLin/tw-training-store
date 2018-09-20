package com.example.store.shoppingcarts;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartProduct {
    @Id
    private Integer productId;
    private Integer quantity;

    public CartProduct() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
