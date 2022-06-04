package com.portfolio.TellMeWhenApp.ShoppingList.Service;

import com.portfolio.TellMeWhenApp.Mapper.ShoppingProductMapper;
import com.portfolio.TellMeWhenApp.Service.GenericProductService;
import com.portfolio.TellMeWhenApp.ShoppingList.Dto.ShoppingProductDto;
import com.portfolio.TellMeWhenApp.ShoppingList.Entity.ShoppingProduct;
import com.portfolio.TellMeWhenApp.ShoppingList.Repository.ShoppingProductRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ShoppingProductServiceImpl implements GenericProductService<ShoppingProductDto> {

    public static final Logger LOGGER = LogManager.getLogger(ShoppingProductServiceImpl.class);
    ShoppingProductRepository productRepository;
    ShoppingProductMapper productMapper;

    @Override
    public void save(ShoppingProductDto shoppingProductDto) {
        productRepository.save(productMapper.mapDtoIntoEntity(shoppingProductDto));
    }

    public void update(ShoppingProductDto shoppingProductDto) {
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ShoppingProductDto findOne(Integer id) {
        Optional<ShoppingProduct> foundProduct = productRepository.findById(id);
        if (foundProduct.isEmpty()) {
            LOGGER.warn("Product doesn't exist");
            throw new NoSuchElementException("Product doesn't exist");
        }
        LOGGER.info("Found product with id : " + id);
        return productMapper.mapEntityIntoDto(foundProduct.get());
    }

    @Override
    public List<ShoppingProductDto> getAll() {
        List<ShoppingProduct> shoppingProductEntities = productRepository.findAll();
        List<ShoppingProductDto> shoppingProductDtoList = new ArrayList<>();
        for (ShoppingProduct entity : shoppingProductEntities) {
            shoppingProductDtoList.add(productMapper.mapEntityIntoDto(entity));
        }
        return shoppingProductDtoList;
    }


}
