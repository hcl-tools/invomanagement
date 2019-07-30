package com.controller;

import com.bean.Business;
import com.bean.Item;
import com.dao.ItemRepo;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemRepo dao;

    @Autowired
    ItemService itemService;

    //READ ALL
    @RequestMapping("/all")
    public ResponseEntity getAllItems() {
        return ok(dao.findAll());
    }

    //FIND BY ID
    @RequestMapping("/find")
    public ResponseEntity getById(@RequestParam("id") int id){
        boolean exists = itemService.checkItemExists(id);
        if (exists){
            return ok(dao.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No item with that id exists");
    }

    //UPDATE
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity addItemsToDao(@RequestParam("items") List<Item> items){
        items.forEach(item -> {
            dao.save(item);
        });
        return ResponseEntity.status(HttpStatus.OK).body("Items saved to database");
    }

    @RequestMapping(value = "/addtodb", method = RequestMethod.POST)
    public ResponseEntity addItemsToDao(){
        List<Item> items = getList();
        System.err.println("inseide addtodb");
        items.forEach(item -> {
            System.err.println(item);
            dao.save(item);
        });
        return ResponseEntity.status(HttpStatus.OK).body("Items saved to database");
    }

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public ResponseEntity addItemsToDao(@RequestParam("title") String title, @RequestParam("category") String category,
            @RequestParam("sell") double sell, @RequestParam("buy") double buy, @RequestParam("stockcount") int stockcount,
            @RequestParam("bustitle") String bustitle, @RequestParam("address") String address){
        Business business = new Business(bustitle, address);
        Item item = new Item(title, category, sell, buy, stockcount, business);
        System.err.println("inside additem");
        dao.save(item);
        return ResponseEntity.status(HttpStatus.OK).body("Item saved to database");
    }

    //DELETE
    @RequestMapping("/delete")
    public ResponseEntity deleteItem(@RequestParam("id") int id){
        boolean exists = itemService.checkItemExists(id);
        if (exists){
            return ResponseEntity.status(HttpStatus.OK).body("Item with id" + id + " deleted from database");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No item with that id exists");
    }


    public ResponseEntity ok(Object o){
        return ResponseEntity.ok(o);
    }

    public List<Item> getList(){
        List<Item> itemsList = new ArrayList<>();
        Business business1 = new Business("coles", "ivanhoe");
        Business business2 = new Business("coles", "heidelberg");
        Business business3 = new Business("coles", "bundoora");
        Business business4 = new Business("woolworths", "ivanhoe");
        Business business = new Business("green farms", "mildura");
        Business business5 = new Business("bidvest", "sydney");

        Item item1 = new Item("lettuce", "fruit and vegetables", 2.50, 1.50, 5, business);
        Item item2 = new Item("tomato", "fruit and vegetables", 0.50, 0.25, 10, business);
        Item item3 = new Item("apple", "fruit and vegetables", 0.50, 0.25, 15, business);
        Item item4 = new Item("toothpaste", "personal care", 5.50, 10.00, 100, business5);
        Item item5 = new Item("roast chicken", "meat", 10.00, 12.50, 20, business1);
        Item item6 = new Item("toothpaste", "personal care", 5.00, 7.50, 50, business2);
        Item item7 = new Item("samboy chips", "snacks", 2.50, 1.50, 30, business3);
        Item item8 = new Item("meredith goats cheese", "cheese", 7.00, 4.00, 10, business4);
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        itemsList.add(item5);
        itemsList.add(item6);
        itemsList.add(item7);
        itemsList.add(item8);
        return itemsList;
    }

    @RequestMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.status(HttpStatus.OK).body("test successful");
    }

}
