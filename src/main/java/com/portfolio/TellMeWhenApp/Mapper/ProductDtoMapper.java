package com.portfolio.TellMeWhenApp.Mapper;

import com.portfolio.TellMeWhenApp.Product.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Product.ProductDto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
@Component
public class ProductDtoMapper {

    public ProductEntity mapProductIntoEntity(ProductDto productDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productDto.name());
        productEntity.setProductType(productDto.type());
        productEntity.setPlaceOfStorage(productDto.place());

        LocalDate purchaseDate = LocalDate.parse(productDto.purchaseDate(), formatter);
        productEntity.setPurchaseDate(purchaseDate);
        LocalDate expiryDate = LocalDate.parse(productDto.expiryDate(), formatter);
        productEntity.setExpiryDate(expiryDate);

        return productEntity;
    }

    public ProductDto mapProductIntoDto(ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getId(),
                productEntity.getProductName(),
                productEntity.getProductType(),
                productEntity.getPlaceOfStorage(),
                productEntity.getPurchaseDate().toString(),
                productEntity.getExpiryDate().toString());
    }

}
