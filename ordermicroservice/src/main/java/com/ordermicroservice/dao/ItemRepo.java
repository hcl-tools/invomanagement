package com.ordermicroservice.dao;

import com.ordermicroservice.bean.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<Item, String> {
    Item findBy_id(ObjectId _id);
}