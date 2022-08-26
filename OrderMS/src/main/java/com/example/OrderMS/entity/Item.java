package com.example.OrderMS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Item")
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemID;
    private String item_name;
    private int item_price;



}
