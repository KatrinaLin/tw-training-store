package com.example.store.orders;

import java.util.List;

public class Order {
    private List<OrderProduct> productList;

    public Order() {
    }

    public void setProductList(List<OrderProduct> productList) {
        this.productList = productList;
    }

    public List<OrderProduct> getProductList() {
        return productList;
    }
}
