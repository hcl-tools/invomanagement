package com.dao;

import com.bean.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Integer> {

    @Query(value = "SELECT i FROM Item i WHERE i.sell", nativeQuery = false)
    List<Item> findSoldItems();

    @Query(value = "SELECT i FROM Item i WHERE i.buy", nativeQuery = false)
    List<Item> findBoughtItems();

}
