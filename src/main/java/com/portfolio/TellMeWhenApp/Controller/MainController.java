package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.ModelDTO.ProductDTO;
import com.portfolio.TellMeWhenApp.Service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    ProductServiceImpl productService;

    public MainController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/addProduct")
    public String newProduct(Model model, ProductDTO product) {
        List<String> types = productService.getAllProductTypes();
        List<String> places = productService.getAllProductPlacesOfStorage();
        model.addAttribute("types", types);
        model.addAttribute("places", places);
        model.addAttribute("product", product);
        return "addProduct";
    }

}
