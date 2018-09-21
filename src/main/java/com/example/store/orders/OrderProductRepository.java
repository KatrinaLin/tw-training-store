package com.example.store.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {

    @Query("select op from OrderProduct op where op.orderId = ?1")
    Stream<OrderProduct> findAllByCustomQueryAndStream(Integer orderId);
}
