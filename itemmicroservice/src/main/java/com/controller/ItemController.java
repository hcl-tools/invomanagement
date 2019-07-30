package com.controller;

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

import java.util.List;

@RestController
@RequestMapping("/")
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

    //find by sold
    @RequestMapping("/sold")
    public ResponseEntity getSoldItems(){
        return ok(dao.findSoldItems());
    }

    //find by bought
    @RequestMapping("/bought")
    public ResponseEntity getBoughtItems(){
        return ok(dao.findBoughtItems());
    }

    //UPDATE
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity addItemsToDao(@RequestParam("items") List<Item> items){
        items.forEach(item -> {
            dao.save(item);
        });
        return ResponseEntity.status(HttpStatus.OK).body("Items saved to database");
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

}
