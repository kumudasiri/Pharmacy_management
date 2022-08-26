package com.example.UserMS.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Item {


    private Long itemID;
    private String item_name;
    private int item_price;



}
