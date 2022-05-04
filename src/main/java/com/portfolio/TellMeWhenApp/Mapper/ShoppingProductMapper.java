package com.portfolio.TellMeWhenApp.Mapper;

import com.portfolio.TellMeWhenApp.ShoppingList.Dto.ShoppingProductDto;
import com.portfolio.TellMeWhenApp.ShoppingList.Model.ShoppingProduct;
import com.portfolio.TellMeWhenApp.StorageProduct.Dto.StorageProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Data
@Component
public class ShoppingProductMapper {

    public StorageProductDto mapShoppingDtoToStorageProductDto(ShoppingProductDto shoppingProductDto) {
        return new StorageProductDto(
                null,
                shoppingProductDto.name(),
                shoppingProductDto.type(),
                "Other",
                LocalDate.now().toString(),
                LocalDate.now().plus(3, ChronoUnit.DAYS).toString());
    }

    public ShoppingProduct mapDtoIntoEntity(ShoppingProductDto shoppingProductDto) {
        ShoppingProduct shoppingProduct = new ShoppingProduct();
        shoppingProduct.setProductName(shoppingProductDto.name());
        shoppingProduct.setProductType("Other");
        return shoppingProduct;
    }

    public ShoppingProductDto mapEntityIntoDto(ShoppingProduct shoppingProduct) {
        return new ShoppingProductDto(
                shoppingProduct.getId(),
                shoppingProduct.getProductName(),
                shoppingProduct.getProductType());
    }
}
