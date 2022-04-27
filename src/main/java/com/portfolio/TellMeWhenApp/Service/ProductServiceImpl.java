package com.portfolio.TellMeWhenApp.Service;

import com.portfolio.TellMeWhenApp.Mapper.ProductDtoMapper;
import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Model.ProductStorageLocation;
import com.portfolio.TellMeWhenApp.Model.ProductType;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;
import com.portfolio.TellMeWhenApp.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ProductDto> createListOfMappedProductDto(List<ProductEntity> productEntities) {
        List<ProductDto> productDtos = new ArrayList<>();

        for (ProductEntity entity : productEntities) {
            productDtos.add(productDtoMapper.mapProductIntoDto(entity));
        }
        return productDtos;
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
        return EnumSet.allOf(ProductStorageLocation.class).stream().map(ProductStorageLocation::toString).collect(Collectors.toList());
    }
}
