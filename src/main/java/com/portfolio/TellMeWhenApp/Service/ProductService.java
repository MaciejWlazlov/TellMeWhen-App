package com.portfolio.TellMeWhenApp.Service;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void deleteProduct(Integer id);

    ProductDto getSingleProduct(Integer id);

    List<ProductEntity> getAllProducts();
}
