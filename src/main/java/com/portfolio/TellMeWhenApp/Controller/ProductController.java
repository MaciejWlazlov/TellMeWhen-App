package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;
import com.portfolio.TellMeWhenApp.Service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class ProductController {

    public static final Logger LOGGER = LogManager.getLogger(ProductController.class);
    private final ProductServiceImpl productService;

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("productDto") @Valid ProductDto productDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute("types", productTypesList);
            model.addAttribute("places", productPlacesOfStorageList);
            LOGGER.warn("Errors in fields");
            return "addProductForm";
        } else {
            productService.saveProduct(productDto);
            LOGGER.info("Saved to the database successfully");
        }
        return "savedProduct";
    }

    @GetMapping("/newProduct")
    public String newProduct(Model model, @ModelAttribute("productDto") ProductDto productDto) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        model.addAttribute("types", productTypesList);
        model.addAttribute("places", productPlacesOfStorageList);
        LOGGER.info("Added objects to view model");
        return "addProductForm";
    }

}
