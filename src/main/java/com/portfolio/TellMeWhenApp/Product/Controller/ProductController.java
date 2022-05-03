package com.portfolio.TellMeWhenApp.Product.Controller;

import com.portfolio.TellMeWhenApp.Product.ProductDto.ProductDto;
import com.portfolio.TellMeWhenApp.Product.Service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class ProductController {

    public static final Logger LOGGER = LogManager.getLogger(ProductController.class);
    private final ProductServiceImpl productService;

    @GetMapping("/newProduct")
    public String newProduct(@ModelAttribute("productDto") ProductDto productDto, Model model) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        model.addAttribute("types", productTypesList);
        model.addAttribute("places", productPlacesOfStorageList);
        LOGGER.info("New product model added to the view");
        return "addNewProductForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("productDto") @Valid ProductDto productDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute("types", productTypesList);
            model.addAttribute("places", productPlacesOfStorageList);
            LOGGER.warn("Errors in the fields");
            return "addNewProductForm";
        } else {
            productService.saveProduct(productDto);
            LOGGER.info("Saved new product to the database successfully");
        }
        return "savedProduct";
    }

    @GetMapping("/editProduct")
    public String editProduct(@RequestParam("id") Integer id, Model model) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        ProductDto productToBeUpdated = productService.getSingleProduct(id);
        model.addAttribute("productToBeUpdated", productToBeUpdated);
        model.addAttribute("types", productTypesList);
        model.addAttribute("places", productPlacesOfStorageList);
        LOGGER.info("Edited product model added to the view");
        return "editProductForm";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("productDto") @Valid ProductDto productDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute("types", productTypesList);
            model.addAttribute("places", productPlacesOfStorageList);
            LOGGER.warn("Errors in the updated fields");
            return "editProductForm";
        } else {
            productService.updateProduct(productDto);
            LOGGER.info("Updated product successfully");
        }
        return "redirect:myStorage";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Integer id) {
        productService.deleteProduct(id);
        LOGGER.info("Product with id= " + id + " has been successfully deleted");
        return "redirect:myStorage";
    }
}
