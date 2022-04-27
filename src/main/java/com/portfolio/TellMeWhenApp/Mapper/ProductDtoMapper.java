package com.portfolio.TellMeWhenApp.Mapper;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@Component
public class ProductDtoMapper {

    public ProductEntity mapProductIntoEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productDto.name());
        productEntity.setProductType(productDto.type());
        productEntity.setPlaceOfStorage(productDto.place());
        return productEntity;
    }

    public ProductDto mapProductIntoDto(ProductEntity productEntity){
        return new ProductDto(productEntity.getId(),productEntity.getProductName(), productEntity.getProductType(), productEntity.getPlaceOfStorage());
    }

}
