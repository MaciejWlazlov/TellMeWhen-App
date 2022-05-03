package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.Product.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Product.ProductDto.ProductDto;
import com.portfolio.TellMeWhenApp.Product.Service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class StorageController {

    public static final Logger LOGGER = LogManager.getLogger(StorageController.class);

    ProductServiceImpl productService;

    @GetMapping("/myStorage")
    public String showAllProducts(Model model) {

        List<ProductEntity> productEntities = productService.getAllProducts();
        List<ProductDto> listOfProductDto = productService.createListOfMappedProductDto(productEntities);
        model.addAttribute("listOfProductDto", listOfProductDto);

        LOGGER.info("Successfully loaded all products");
        return "myStorage";
    }

}
