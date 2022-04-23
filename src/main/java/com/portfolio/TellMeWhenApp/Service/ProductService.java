package com.portfolio.TellMeWhenApp.Service;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;

import java.util.List;

public interface ProductService {

    ProductEntity saveProduct(ProductDto productDto);

    List<ProductEntity> getAllProducts();
}
