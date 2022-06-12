package com.portfolio.tellmewhenapp.mapper;

import com.portfolio.tellmewhenapp.storageProduct.dto.StorageProductDto;
import com.portfolio.tellmewhenapp.storageProduct.model.Entity.StorageProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
@Component
public class StorageProductMapper {

    public static final Logger LOGGER = LogManager.getLogger(StorageProductMapper.class);

    public StorageProduct mapDtoIntoEntity(StorageProductDto storageProductDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StorageProduct storageProduct = new StorageProduct();
        storageProduct.setProductName(storageProductDto.name());
        storageProduct.setProductType(storageProductDto.type());
        storageProduct.setPlaceOfStorage(storageProductDto.place());

        if (storageProductDto.purchaseDate().equals("")) {
            storageProduct.setPurchaseDate(LocalDate.now());
            LOGGER.warn("No purchase date selected -> inserting today's date");
        } else {
            LocalDate purchaseDate = LocalDate.parse(storageProductDto.purchaseDate(), formatter);
            storageProduct.setPurchaseDate(purchaseDate);
        }
        LocalDate expiryDate = LocalDate.parse(storageProductDto.expiryDate(), formatter);
        storageProduct.setExpiryDate(expiryDate);
        return storageProduct;
    }

    public StorageProductDto mapEntityIntoDto(StorageProduct storageProduct) {
        return new StorageProductDto(storageProduct.getId(),
                storageProduct.getProductName(),
                storageProduct.getProductType(),
                storageProduct.getPlaceOfStorage(),
                storageProduct.getPurchaseDate().toString(),
                storageProduct.getExpiryDate().toString());
    }
}
