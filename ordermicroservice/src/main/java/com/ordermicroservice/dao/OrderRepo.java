package com.ordermicroservice.dao;

import com.ordermicroservice.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
