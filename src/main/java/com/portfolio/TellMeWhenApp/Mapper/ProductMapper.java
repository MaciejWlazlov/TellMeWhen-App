package com.portfolio.TellMeWhenApp.Mapper;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ProductMapper {

    ProductEntity productEntity;
    ProductDTO ProductDTO;

    public ProductEntity mapProductIntoEntity(ProductDTO productDTO) {
        productEntity.setProductName(productDTO.getName());
        productEntity.setProductType(productDTO.getType());
        productEntity.setPlaceOfStorage(productDTO.getPlace());
        return productEntity;
    }

}
