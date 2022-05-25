package com.portfolio.TellMeWhenApp.StorageProduct.Service;

import com.portfolio.TellMeWhenApp.Mapper.StorageProductMapper;
import com.portfolio.TellMeWhenApp.Service.GenericProductService;
import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProduct;
import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProductLocation;
import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProductType;
import com.portfolio.TellMeWhenApp.StorageProduct.Repository.StorageProductRepository;
import com.portfolio.TellMeWhenApp.StorageProduct.Dto.StorageProductDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StorageProductServiceImpl implements GenericProductService<StorageProductDto> {

    public static final Logger LOGGER = LogManager.getLogger(StorageProductServiceImpl.class);

    StorageProductRepository productRepository;
    StorageProductMapper productMapper;

    @Override
    public void save(StorageProductDto storageProductDto) {
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
        List<StorageProduct> expiringProducts = productRepository.findTop3ByExpiryDateAfter(LocalDate.now());
        List<StorageProductDto> expiringProductsDtos = new ArrayList<>();

        for (StorageProduct product : expiringProducts) {
            expiringProductsDtos.add(productMapper.mapEntityIntoDto(product));
        }
        return expiringProductsDtos;
    }
}
