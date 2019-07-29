package com.service;

import com.dao.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemService {

    @Autowired
    ItemRepo dao;

    public boolean checkItemExists(int id){
        return dao.existsById(id);
    }

}
