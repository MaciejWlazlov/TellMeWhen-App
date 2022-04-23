package com.portfolio.TellMeWhenApp.Service;

import com.portfolio.TellMeWhenApp.Mapper.ProductDtoMapper;
import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Model.ProductStorage;
import com.portfolio.TellMeWhenApp.Model.ProductType;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;
import com.portfolio.TellMeWhenApp.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductDtoMapper productDtoMapper;

    public ProductEntity mapProductDtoToEntity(ProductDto productDto) {
        return productDtoMapper.mapProductIntoEntity(productDto);
    }

    @Override
    public ProductEntity saveProduct(ProductDto productDto) {
        ProductEntity newProductEntity = mapProductDtoToEntity(productDto);
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
