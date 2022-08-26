package com.example.OrderMS.service;

import com.example.OrderMS.entity.Orders;
import com.example.OrderMS.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Orders saveOrder(Orders orders) {
        return orderRepo.save(orders);
    }
    public List<Orders> findAll(){
        return orderRepo.findAll();
    }
}
