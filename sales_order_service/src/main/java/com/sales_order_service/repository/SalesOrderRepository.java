package com.sales_order_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales_order_service.entity.SalesOrder;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
//	@Query("select u from sale_order u where u.cust_id :=cId")
//	List<SalesOrder> getOrderByCustId(@Param("cId") long cId);
	List<SalesOrder> findByCustId(long cId);
}