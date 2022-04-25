package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;
import com.portfolio.TellMeWhenApp.Service.ProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    public static final Logger LOGGER = LogManager.getLogger(MainController.class);

    ProductServiceImpl productService;

    public MainController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/newProduct")
    public String newProduct(Model model, ProductDto productDto) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        model.addAttribute("types", productTypesList);
        model.addAttribute("places", productPlacesOfStorageList);
        model.addAttribute("product", productDto);
        LOGGER.info("Added obiects to view model");
        return "addProductForm";
    }

}
