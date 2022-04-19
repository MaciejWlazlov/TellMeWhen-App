package com.portfolio.TellMeWhenApp.ProductData;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class Product {

    private String productName;
    private ProductCategory productCategory;
    private ProductStorage productStorage;
}
