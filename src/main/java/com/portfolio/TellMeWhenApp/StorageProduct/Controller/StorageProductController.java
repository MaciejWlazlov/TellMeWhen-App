package com.portfolio.TellMeWhenApp.StorageProduct.Controller;

import com.portfolio.TellMeWhenApp.StorageProduct.Service.StorageProductServiceImpl;
import com.portfolio.TellMeWhenApp.StorageProductDto.StorageProductDto;
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
public class StorageProductController {

    public static final Logger LOGGER = LogManager.getLogger(StorageProductController.class);
    private final StorageProductServiceImpl productService;

    @GetMapping("/newProduct")
    public String newProduct(@ModelAttribute("productDto") StorageProductDto storageProductDto, Model model) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        model.addAttribute("types", productTypesList);
        model.addAttribute("places", productPlacesOfStorageList);
        LOGGER.info("New product model added to the view");
        return "addNewProductForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid StorageProductDto storageProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute("productDto", storageProductDto);
            model.addAttribute("types", productTypesList);
            model.addAttribute("places", productPlacesOfStorageList);
            LOGGER.warn("Errors in the fields");
            return "addNewProductForm";
        } else {
            productService.save(storageProductDto);
            LOGGER.info("Saved new product to the database successfully");
        }
        return "savedProduct";
    }

    @GetMapping("/editProduct")
    public String editProduct(@RequestParam("id") Integer id, Model model) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        StorageProductDto productToBeUpdated = productService.findOne(id);
        model.addAttribute("productToBeUpdated", productToBeUpdated);
        model.addAttribute("types", productTypesList);
        model.addAttribute("places", productPlacesOfStorageList);
        LOGGER.info("Edited product model added to the view");
        return "editProductForm";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("productToBeUpdated") @Valid StorageProductDto storageProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute("types", productTypesList);
            model.addAttribute("places", productPlacesOfStorageList);
            LOGGER.warn("Errors in the updated fields");
            return "editProductForm";
        } else {
            productService.update(storageProductDto);
            LOGGER.info("Updated product successfully");
        }
        return "redirect:myStorage";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Integer id) {
        productService.delete(id);
        LOGGER.info("Product with id= " + id + " has been successfully deleted");
        return "redirect:myStorage";
    }
}
