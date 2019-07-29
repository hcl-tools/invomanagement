package com.ordermicroservice.services;

import com.ordermicroservice.bean.Order;
import com.ordermicroservice.dao.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API")
public class WebLayer {

    @Autowired
    OrderRepo orderRepo;

    @RequestMapping("/all")
    public List<Order> allOrders() {
        return orderRepo.findAll();
    }

    @RequestMapping("/get/{id}")
    public Order getById(@PathVariable int id) {
        return orderRepo.findById(id).orElseThrow();
    }
}
