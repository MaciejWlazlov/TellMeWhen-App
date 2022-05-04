package com.portfolio.TellMeWhenApp.Mapper;

import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProduct;
import com.portfolio.TellMeWhenApp.StorageProductDto.StorageProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
@Component
public class StorageProductMapper {

    public StorageProduct mapProductIntoEntity(StorageProductDto storageProductDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StorageProduct storageProduct = new StorageProduct();
        storageProduct.setProductName(storageProductDto.name());
        storageProduct.setProductType(storageProductDto.type());
        storageProduct.setPlaceOfStorage(storageProductDto.place());

        LocalDate purchaseDate = LocalDate.parse(storageProductDto.purchaseDate(), formatter);
        storageProduct.setPurchaseDate(purchaseDate);
        LocalDate expiryDate = LocalDate.parse(storageProductDto.expiryDate(), formatter);
        storageProduct.setExpiryDate(expiryDate);

        return storageProduct;
    }

    public StorageProductDto mapProductIntoDto(StorageProduct storageProduct) {
        return new StorageProductDto(
                storageProduct.getId(),
                storageProduct.getProductName(),
                storageProduct.getProductType(),
                storageProduct.getPlaceOfStorage(),
                storageProduct.getPurchaseDate().toString(),
                storageProduct.getExpiryDate().toString());
    }

}
