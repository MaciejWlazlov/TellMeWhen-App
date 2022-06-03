package com.portfolio.TellMeWhenApp.StorageProduct.Controller;

import com.portfolio.TellMeWhenApp.StorageProduct.Dto.StorageProductDto;
import com.portfolio.TellMeWhenApp.StorageProduct.Service.StorageProductServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/myStorage")
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
        return "addNewProductToStorageForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("productDto") @Valid StorageProductDto storageProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute("types", productTypesList);
            model.addAttribute("places", productPlacesOfStorageList);
            LOGGER.warn("Errors in the fields");
            return "addNewProductToStorageForm";
        } else {
            productService.save(storageProductDto);
            LOGGER.info("Saved new product to the database successfully");
        }
        return "StorageProductSaveSuccess";
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
        return "editStorageProductForm";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("productToBeUpdated") @Valid StorageProductDto storageProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            List<String> productTypesList = productService.getAllProductTypes();
            List<String> productPlacesOfStorageList = productService.getAllProductPlacesOfStorage();
            model.addAttribute("types", productTypesList);
            model.addAttribute("places", productPlacesOfStorageList);
            LOGGER.warn("Errors in the updated fields");
            return "editStorageProductForm";
        } else {
            productService.update(storageProductDto);
            LOGGER.info("Updated product successfully");
        }
        return "redirect:myStorage";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Integer id) {
        productService.delete(id);
        LOGGER.info("Product with id = " + id + " has been successfully deleted");
        return "redirect:myStorage";
    }
}
