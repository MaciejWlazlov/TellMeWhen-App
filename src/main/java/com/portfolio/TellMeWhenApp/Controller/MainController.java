package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.StorageProduct.Service.StorageProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    public static final Logger LOGGER = LogManager.getLogger(MainController.class);

    StorageProductServiceImpl productService;

    public MainController(StorageProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }



}
