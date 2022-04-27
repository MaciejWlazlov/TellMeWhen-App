package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.ModelDTO.ProductDto;
import com.portfolio.TellMeWhenApp.Service.ProductServiceImpl;
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
        List<ProductDto> productDtos = productService.createListOfMappedProductDto(productEntities);
        model.addAttribute("listOfProductDto", productDtos);

        LOGGER.info("Successfully loaded all products");
        return "myStorage";
    }

}
