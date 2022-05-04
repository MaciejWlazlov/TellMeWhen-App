package com.portfolio.TellMeWhenApp.ShoppingList.Dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ShoppingProductDto(
        Integer id,
        @NotNull
        @Length(min = 3, max = 20, message = "The product name should have at least 3 characters")
        String name,
        String type) {
}
