package com.portfolio.TellMeWhenApp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "shopping_list")
@Getter
@Setter
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shop_product_name")
    private String productName;
    @Column(name = "shop_product_type")
    private String productType;
    @Column(name = "shop_place_of_storage")
    private String placeOfStorage;
}
