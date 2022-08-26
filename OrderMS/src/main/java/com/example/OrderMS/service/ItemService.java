package com.example.OrderMS.service;


import com.example.OrderMS.entity.Item;
import com.example.OrderMS.entity.Orders;
import com.example.OrderMS.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    public Item saveItem(Item item) {
        itemRepo.save(item);
        return item;
    }

    public Optional<Item> findItemByID(Long itemID) {
        return itemRepo.findById(itemID);
    }

    public List<Item> findAll() {
        return itemRepo.findAll();
    }
}
