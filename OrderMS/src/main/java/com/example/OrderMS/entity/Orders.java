package com.example.OrderMS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "`Orders`")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long orderID;

    private String orderDate;

    private String drugName;

    private int drugQuantity;

    private int drugPrice;

    private Long userID;



}
