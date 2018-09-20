package com.example.store.orders;

import java.util.List;

public class Order {

    private Integer orderId;
    private List<OrderProduct> productList;
    private String status;

    public Order() {
    }

    public void setProductList(List<OrderProduct> productList) {
        this.productList = productList;
    }

    public List<OrderProduct> getProductList() {
        return productList;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
