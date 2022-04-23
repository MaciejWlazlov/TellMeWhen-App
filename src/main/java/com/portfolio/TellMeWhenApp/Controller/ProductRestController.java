package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductRestController {

    ProductServiceImpl productService;

    @GetMapping("/getAll")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }
}
