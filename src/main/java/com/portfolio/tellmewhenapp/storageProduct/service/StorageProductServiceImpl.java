package com.portfolio.tellmewhenapp.storageProduct.service;

import com.portfolio.tellmewhenapp.mapper.StorageProductMapper;
import com.portfolio.tellmewhenapp.service.IProductService;
import com.portfolio.tellmewhenapp.storageProduct.model.Entity.StorageProduct;
import com.portfolio.tellmewhenapp.storageProduct.model.StorageProductLocation;
import com.portfolio.tellmewhenapp.storageProduct.model.StorageProductType;
import com.portfolio.tellmewhenapp.storageProduct.repository.StorageProductRepository;
import com.portfolio.tellmewhenapp.storageProduct.dto.StorageProductDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StorageProductServiceImpl implements IProductService<StorageProductDto> {

    public static final Logger LOGGER = LogManager.getLogger(StorageProductServiceImpl.class);

    StorageProductRepository productRepository;
    StorageProductMapper productMapper;

    @Override
    public void add(StorageProductDto storageProductDto) {
        productRepository.save(productMapper.mapDtoIntoEntity(storageProductDto));
    }

    @Override
    public void update(StorageProductDto storageProductDto) {
        StorageProduct storageProduct = productRepository.findById(storageProductDto.id()).orElseThrow();
        storageProduct.setProductName(storageProductDto.name());
        storageProduct.setProductType(storageProductDto.type());
        storageProduct.setPlaceOfStorage(storageProductDto.place());
        productRepository.save(storageProduct);

        LOGGER.info("zaktualizowano produkt");
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public StorageProductDto findOne(Integer id) {
        StorageProduct storageProduct = productRepository.findById(id).orElseThrow();
        return productMapper.mapEntityIntoDto(storageProduct);
    }

    public List<StorageProductDto> getAll() {
        List<StorageProduct> productEntities = productRepository.findAll();
        List<StorageProductDto> storageProductDtos = new ArrayList<>();

        for (StorageProduct entity : productEntities) {
            storageProductDtos.add(productMapper.mapEntityIntoDto(entity));
        }
        return storageProductDtos;
    }

    public List<String> getAllProductTypes() {
        return EnumSet.allOf(StorageProductType.class).stream().map(StorageProductType::toString).collect(Collectors.toList());
    }

    public List<String> getAllProductPlacesOfStorage() {
        return EnumSet.allOf(StorageProductLocation.class).stream().map(StorageProductLocation::toString).collect(Collectors.toList());
    }

    public List<StorageProductDto> getExpiringProducts() {
        List<StorageProduct> expiringProducts = productRepository.findFirst5ByExpiryDateBetweenOrderByExpiryDate(LocalDate.now(),LocalDate.now().plus(1, ChronoUnit.WEEKS));
        List<StorageProductDto> expiringProductsDtos = new ArrayList<>();

        for (StorageProduct product : expiringProducts) {
            expiringProductsDtos.add(productMapper.mapEntityIntoDto(product));
        }
        return expiringProductsDtos;
    }
}
