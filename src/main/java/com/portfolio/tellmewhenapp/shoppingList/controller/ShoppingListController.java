package com.portfolio.tellmewhenapp.shoppingList.controller;

import com.portfolio.tellmewhenapp.shoppingList.dto.ShoppingProductDto;
import com.portfolio.tellmewhenapp.shoppingList.service.ShoppingProductServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ShoppingListController {

    public static final Logger LOGGER = LogManager.getLogger(ShoppingListController.class);
    ShoppingProductServiceImpl shoppingProductService;

    @GetMapping("/shoppingList")
    public String showAllProducts(Model model) {

        List<ShoppingProductDto> listOfShoppingProductDto = shoppingProductService.getAll();
        model.addAttribute("listOfShoppingProductDto", listOfShoppingProductDto);

        LOGGER.info("Successfully loaded all purchases");
        return "shoppingList";
    }
}
