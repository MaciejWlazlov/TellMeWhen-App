package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDTO;
import com.portfolio.TellMeWhenApp.Service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductServiceImpl productService;

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDTO product, Model model) {
        model.addAttribute("product", product);
        productService.saveProduct(product);
        return "result";
    }

    @GetMapping("/getAll")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }
}
