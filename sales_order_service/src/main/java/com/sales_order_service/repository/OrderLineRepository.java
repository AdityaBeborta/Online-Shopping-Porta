package com.sales_order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales_order_service.entity.OrderLineItem;

public interface OrderLineRepository extends JpaRepository<OrderLineItem, Long> {

}
