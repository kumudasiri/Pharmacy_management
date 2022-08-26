package com.example.OrderMS.controller;


import com.example.OrderMS.entity.Item;
import com.example.OrderMS.entity.Orders;
import com.example.OrderMS.service.ItemService;
import com.example.OrderMS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    public RestTemplate restTemplate;

    @PostMapping("/save")
    public Orders save(@RequestBody Orders orders) {
        orderService.saveOrder(orders);
        return orders;
    }

    @GetMapping("/orders")
    public List<Orders> getOrders(){
        return orderService.findAll();
    }

    @RequestMapping("/{itemID}")
    public Optional<Item> getItem(@PathVariable("itemID") Long itemID){
        Optional<Item> item = itemService.findItemByID(itemID);
        return item;
    }

    @GetMapping("/Allorders")
    public List<Item> getAllItems(){
        return itemService.findAll();
    }

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item){
        itemService.saveItem(item);
        return item;

    }




}
