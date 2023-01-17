package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entities.Customer_Sos;

public interface CustomerSosRepository extends JpaRepository<Customer_Sos, Long> {

}
