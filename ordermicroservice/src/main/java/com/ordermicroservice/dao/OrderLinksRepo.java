package com.ordermicroservice.dao;

import com.ordermicroservice.bean.OrderLinks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLinksRepo extends JpaRepository<OrderLinks, Integer> {

}
