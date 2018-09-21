package com.example.store.orders;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store_order")
public class Order {

    @Id
    private Integer orderId;
    private String status;

    @OneToMany(mappedBy="orderId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> productList;


    public Order() {
    }

    public void setProductList(List<OrderProduct> productList) {
        this.productList = productList;
    }

    public List<OrderProduct> getProductList() {
        return productList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
