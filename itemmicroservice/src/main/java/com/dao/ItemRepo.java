package com.dao;

import com.bean.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends MongoRepository<Item, Integer> {
    public Item findAllBy_id_Counter();



}
