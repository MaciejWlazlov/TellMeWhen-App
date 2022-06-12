package com.portfolio.tellmewhenapp.shoppingList.service;

import com.portfolio.tellmewhenapp.mapper.ShoppingProductMapper;
import com.portfolio.tellmewhenapp.service.IProductService;
import com.portfolio.tellmewhenapp.shoppingList.dto.ShoppingProductDto;
import com.portfolio.tellmewhenapp.shoppingList.entity.ShoppingProduct;
import com.portfolio.tellmewhenapp.shoppingList.repository.ShoppingProductRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ShoppingProductServiceImpl implements IProductService<ShoppingProductDto> {

    public static final Logger LOGGER = LogManager.getLogger(ShoppingProductServiceImpl.class);
    ShoppingProductRepository productRepository;
    ShoppingProductMapper productMapper;

    @Override
    public void add(ShoppingProductDto shoppingProductDto) {
        productRepository.save(productMapper.mapDtoIntoEntity(shoppingProductDto));
    }

    public void update(ShoppingProductDto shoppingProductDto) {
        // Does nothing for now
        // TODO implement user info editing
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
        LOGGER.info(MessageFormat.format("Found product with id : {0}", id));
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
