package com.portfolio.TellMeWhenApp.Product.Service;

import com.portfolio.TellMeWhenApp.Product.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Product.ProductDto.ProductDto;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void deleteProduct(Integer id);

    ProductDto getSingleProduct(Integer id);

    List<ProductEntity> getAllProducts();
}
