package com.portfolio.tellmewhenapp.shoppingList.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public record ShoppingProductDto(
        Integer id,
        @NotNull
        @Length(min = 3, max = 20, message = "The product name should have at least 3 and no more than 20 characters")
        String name,
        String type) {
}
