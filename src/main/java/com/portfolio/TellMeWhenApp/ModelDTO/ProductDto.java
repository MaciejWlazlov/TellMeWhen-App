package com.portfolio.TellMeWhenApp.ModelDTO;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ProductDto(
        @NotNull
        @Length(min = 3, max = 20, message = "The product name should have at least 3 characters")
        String name,
        @NotBlank(message = "Please select product type")
        String type,
        @NotBlank(message = "Please select a storage location for your product")
        String place) {
}

