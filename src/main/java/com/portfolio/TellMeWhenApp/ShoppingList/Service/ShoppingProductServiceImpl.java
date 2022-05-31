package com.portfolio.TellMeWhenApp.ShoppingList.Service;

import com.portfolio.TellMeWhenApp.Mapper.ShoppingProductMapper;
import com.portfolio.TellMeWhenApp.ShoppingList.Dto.ShoppingProductDto;
import com.portfolio.TellMeWhenApp.ShoppingList.Entity.ShoppingProduct;
import com.portfolio.TellMeWhenApp.ShoppingList.Repository.ShoppingProductRepository;
import com.portfolio.TellMeWhenApp.Service.GenericProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ShoppingProductServiceImpl implements GenericProductService<ShoppingProductDto> {

    ShoppingProductRepository productRepository;
    ShoppingProductMapper productMapper;

    @Override
    public void save(ShoppingProductDto shoppingProductDto) {
        productRepository.save(productMapper.mapDtoIntoEntity(shoppingProductDto));
    }

    public void update(ShoppingProductDto shoppingProductDto) {
    }

    @Override
    public void delete(Integer id) {productRepository.deleteById(id);
    }

    @Override
    public ShoppingProductDto findOne(Integer id) {
        return productMapper.mapEntityIntoDto(productRepository.findById(id).orElseThrow());
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
