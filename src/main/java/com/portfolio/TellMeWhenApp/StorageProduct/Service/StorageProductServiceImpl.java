package com.portfolio.TellMeWhenApp.StorageProduct.Service;

import com.portfolio.TellMeWhenApp.Mapper.StorageProductMapper;
import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProduct;
import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProductLocation;
import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProductType;
import com.portfolio.TellMeWhenApp.StorageProduct.Repository.ProductRepository;
import com.portfolio.TellMeWhenApp.StorageProductDto.StorageProductDto;
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
public class StorageProductServiceImpl implements GenericProductService<StorageProductDto> {

    public static final Logger LOGGER = LogManager.getLogger(StorageProductServiceImpl.class);

    ProductRepository productRepository;
    StorageProductMapper storageProductMapper;

    public StorageProduct mapProductDtoToEntity(StorageProductDto storageProductDto) {
        return storageProductMapper.mapProductIntoEntity(storageProductDto);
    }
    
    @Override
    public void save(StorageProductDto storageProductDto) {
        StorageProduct newStorageProduct = mapProductDtoToEntity(storageProductDto);
        productRepository.save(newStorageProduct);
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
        return storageProductMapper.mapProductIntoDto(storageProduct);
    }

    public List<StorageProductDto> getAll() {
        List<StorageProduct> productEntities = productRepository.findAll();
        List<StorageProductDto> storageProductDtos = new ArrayList<>();

        for (StorageProduct entity : productEntities) {
            storageProductDtos.add(storageProductMapper.mapProductIntoDto(entity));
        }
        return storageProductDtos;
    }

    public List<String> getAllProductTypes() {
        return EnumSet.allOf(StorageProductType.class).stream().map(StorageProductType::toString).collect(Collectors.toList());
    }

    public List<String> getAllProductPlacesOfStorage() {
        return EnumSet.allOf(StorageProductLocation.class).stream().map(StorageProductLocation::toString).collect(Collectors.toList());
    }
}
