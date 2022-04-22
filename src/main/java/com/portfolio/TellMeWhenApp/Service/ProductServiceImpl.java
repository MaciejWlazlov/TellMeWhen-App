package com.portfolio.TellMeWhenApp.Service;

import com.portfolio.TellMeWhenApp.Mapper.ProductMapper;
import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Model.ProductStorage;
import com.portfolio.TellMeWhenApp.Model.ProductType;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDTO;
import com.portfolio.TellMeWhenApp.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    public ProductEntity mapNewProduct(ProductDTO productDTO) {
        return productMapper.mapProductIntoEntity(productDTO);
    }

    @Override
    public ProductEntity saveProduct(ProductDTO productDTO) {
        ProductEntity newProductEntity = mapNewProduct(productDTO);
        return productRepository.save(newProductEntity);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<String> getAllProductTypes() {
        return EnumSet.allOf(ProductType.class).stream().map(ProductType::toString).collect(Collectors.toList());
    }

    public List<String> getAllProductPlacesOfStorage() {
        return EnumSet.allOf(ProductStorage.class).stream().map(ProductStorage::toString).collect(Collectors.toList());
    }
}
