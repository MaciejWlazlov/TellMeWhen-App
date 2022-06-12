package com.portfolio.tellmewhenapp.storageProduct.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record StorageProductDto(
        Integer id,
        @NotNull
        @Length(min = 3, max = 20, message = "The product name should have at least 3 and no more than 20 characters")
        String name,
        @NotBlank(message = "Please select product type")
        String type,
        @NotBlank(message = "Please select a storage location for your product")
        String place,
        String purchaseDate,
        @NotEmpty(message = "Please select product expiration date")
        String expiryDate) {
}

