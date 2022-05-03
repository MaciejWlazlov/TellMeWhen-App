package com.portfolio.TellMeWhenApp.Product.Service;

import com.portfolio.TellMeWhenApp.Product.Mapper.ProductDtoMapper;
import com.portfolio.TellMeWhenApp.Product.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Product.Model.ProductStorageLocation;
import com.portfolio.TellMeWhenApp.Product.Model.ProductType;
import com.portfolio.TellMeWhenApp.Product.ProductDto.ProductDto;
import com.portfolio.TellMeWhenApp.Product.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    public static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);

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
    public void saveProduct(ProductDto productDto) {
        ProductEntity newProductEntity = mapProductDtoToEntity(productDto);
        productRepository.save(newProductEntity);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        ProductEntity productEntity = productRepository.findById(productDto.id()).orElseThrow();
        productEntity.setProductName(productDto.name());
        productEntity.setProductType(productDto.type());
        productEntity.setPlaceOfStorage(productDto.place());
        productRepository.save(productEntity);

        LOGGER.info("zaktualizowano produkt");
    }

    @Transactional
    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto getSingleProduct(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow();
        return productDtoMapper.mapProductIntoDto(productEntity);
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
