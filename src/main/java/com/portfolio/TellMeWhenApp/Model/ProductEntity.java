package com.portfolio.TellMeWhenApp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_type")
    private String productType;
    @Column(name = "place_of_storage")
    private String placeOfStorage;

}

