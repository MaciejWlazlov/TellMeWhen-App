package com.portfolio.TellMeWhenApp.ModelDTO;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

public record ProductDto(
        @NotNull
        @Length(min = 3,max = 20) String name,
        @NotNull
        String type,
        @NotNull
        String place) {
}

