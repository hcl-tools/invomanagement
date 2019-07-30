package com.ordermicroservice.dao;

import com.ordermicroservice.bean.Order;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order, Integer> {
}
