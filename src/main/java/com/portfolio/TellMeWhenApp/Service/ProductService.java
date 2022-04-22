package com.portfolio.TellMeWhenApp.Service;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductEntity saveProduct(ProductDTO product);

    List<ProductEntity> getAllProducts();
}
