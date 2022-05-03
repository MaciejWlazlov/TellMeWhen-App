package com.portfolio.TellMeWhenApp.Mapper;

import com.portfolio.TellMeWhenApp.Product.ProductDto.ProductDto;
import com.portfolio.TellMeWhenApp.ShoppingList.Model.ShoppingProductEntity;

import java.time.LocalDate;

public class ShoppingProductMapper {

    private ProductDto mapShoppingProductToProductDto(ShoppingProductEntity shoppingProductEntity) {
        return new ProductDto(
                null,
                shoppingProductEntity.getProductName(),
                shoppingProductEntity.getProductType(),
                "Other place",
                LocalDate.now().toString(),
                "Choose expiry date");
    }
}
