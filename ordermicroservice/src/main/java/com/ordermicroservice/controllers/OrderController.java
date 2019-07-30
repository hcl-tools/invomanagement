package com.ordermicroservice.controllers;

import com.ordermicroservice.bean.Business;
import com.ordermicroservice.bean.Item;
import com.ordermicroservice.bean.Order;
import com.ordermicroservice.bean.OrderLinks;
import com.ordermicroservice.dao.ItemRepo;
import com.ordermicroservice.dao.OrderLinksRepo;
import com.ordermicroservice.dao.OrderRepo;
import com.ordermicroservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/order")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderLinksRepo orderLinksRepo;

    @Autowired
    ItemRepo itemRepo;

    // Read
    @RequestMapping("/all")
    public List<Order> allOrders() {
        return orderRepo.findAll();
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id) throws NotFoundException {
        Order order = orderRepo.findById(id).orElseThrow(() -> new NotFoundException("order", id));
        OrderLinks orderLinks = orderLinksRepo.findById(id).orElseThrow(() -> new NotFoundException("order", id));
        return ok(null);
    }

    // Updating.
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity updateOrder(@PathVariable("id") int id, @RequestParam("Order") Order order) {
        order.setId(id);
        orderRepo.save(order);
        return ResponseEntity.status(HttpStatus.OK).body("Updated.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity updateOrderByDetails(@PathVariable("Details") Object details) {
        return ResponseEntity.ok(null);
    }

    // Adding.
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestParam("Order") Order order) {
        orderRepo.save(order);
        return ResponseEntity.status(HttpStatus.OK).body("Added.");
    }

    // Deleting.
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder(@PathVariable("id") int id) {
        orderRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @RequestMapping("/test/setup")
    public ResponseEntity testSetup() {
        Business newBusiness = new Business();
        List<Item> itemList = List.of(

                new Item("dog food", "dog", 4.50, 1.05, 3, newBusiness),
                new Item("cat food", "dog", 4.50, 1.05, 3, newBusiness),
                new Item("fish food", "dog", 4.50, 1.05, 3, newBusiness),
                new Item("cow food", "dog", 4.50, 1.05, 3, newBusiness),
                new Item("person food", "dog", 4.50, 1.05, 3, newBusiness)

        );
        itemList.forEach(item -> {
            itemRepo.save(item);
        });
        return ok("It worked... i think?");
    }

    /**
     * Order number
     *
     * - Order ID
     * - List of links
     */

    /**
     * Order links
     *
     * - ID
     * - Order ID
     * - Item ID
     * - How many
     * - Date
     */

    private ResponseEntity ok(Object obj) {
        return ResponseEntity.ok(obj);
    }
}
