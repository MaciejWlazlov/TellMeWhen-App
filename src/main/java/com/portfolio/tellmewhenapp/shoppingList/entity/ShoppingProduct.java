package com.portfolio.tellmewhenapp.shoppingList.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "shopping_list")
@Getter
@Setter
public class ShoppingProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shop_product_name")
    private String productName;
    @Column(name = "shop_product_type")
    private String productType;
}
