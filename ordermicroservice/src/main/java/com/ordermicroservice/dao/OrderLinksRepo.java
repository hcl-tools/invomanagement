package com.ordermicroservice.dao;

import com.ordermicroservice.bean.OrderLinks;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLinksRepo extends MongoRepository<OrderLinks, Integer> {

}
