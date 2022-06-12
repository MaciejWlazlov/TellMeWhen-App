package com.portfolio.tellmewhenapp.storageProduct.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "products")
public class StorageProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_type")
    private String productType;
    @Column(name = "place_of_storage")
    private String placeOfStorage;
    @Column(name = "date_of_purchase")
    private LocalDate purchaseDate;
    @Column(name = "date_of_expiry")
    private LocalDate expiryDate;

}

