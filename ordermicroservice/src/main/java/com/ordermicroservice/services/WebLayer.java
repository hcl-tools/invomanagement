package com.ordermicroservice.services;

import com.ordermicroservice.bean.Order;
import com.ordermicroservice.dao.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Updating.

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestParam("Order") Order order) {
        orderRepo.save(order);
        return ResponseEntity.status(HttpStatus.OK).body("Added.");
    }
}
