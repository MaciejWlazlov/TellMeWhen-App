package com.portfolio.tellmewhenapp.storageProduct.controller;

import com.portfolio.tellmewhenapp.storageProduct.dto.StorageProductDto;
import com.portfolio.tellmewhenapp.storageProduct.service.StorageProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/storage")
public class StorageProductController {

    public static final Logger LOGGER = LogManager.getLogger(StorageProductController.class);
    private final StorageProductServiceImpl productService;
    private String places;
    private String types;

    @GetMapping("/newProduct")
    public String newProduct(@ModelAttribute("productDto") StorageProductDto storageProductDto, Model model) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        model.addAttribute(types, productTypesList);
        model.addAttribute(places, productPlacesOfStorageList);
        LOGGER.info("New product model added to the view");
        return "addNewProductToStorageForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("productDto") @Valid StorageProductDto storageProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute(types, productTypesList);
            model.addAttribute(places, productPlacesOfStorageList);
            LOGGER.warn("Errors in the fields");
            return "addNewProductToStorageForm";
        } else {
            productService.add(storageProductDto);
            LOGGER.info("Saved new product to the database successfully");
        }
        return "storageProductSaveSuccess";
    }

    @GetMapping("/editProduct")
    public String editProduct(@RequestParam("id") Integer id, Model model) {
        List<String> productTypesList = productService.getAllProductTypes();
        List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
        StorageProductDto productToBeUpdated = productService.findOne(id);
        model.addAttribute("productToBeUpdated", productToBeUpdated);
        model.addAttribute(types, productTypesList);
        model.addAttribute(places, productPlacesOfStorageList);
        LOGGER.info("Edited product model added to the view");
        return "editStorageProductForm";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("productToBeUpdated") @Valid StorageProductDto storageProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute(types, productTypesList);
            model.addAttribute(places, productPlacesOfStorageList);
            LOGGER.warn("Errors in the updated fields");
            return "editStorageProductForm";
        } else {
            productService.update(storageProductDto);
            LOGGER.info("Product updated successfully");
        }
        return "redirect:";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Integer id) {
        productService.delete(id);
        LOGGER.info(MessageFormat.format("Product with id = {0} has been successfully deleted", id));
        return "redirect:";
    }
}
