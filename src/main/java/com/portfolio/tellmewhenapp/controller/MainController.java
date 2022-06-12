package com.portfolio.tellmewhenapp.controller;

import com.portfolio.tellmewhenapp.shoppingList.dto.ShoppingProductDto;
import com.portfolio.tellmewhenapp.shoppingList.service.ShoppingProductServiceImpl;
import com.portfolio.tellmewhenapp.storageProduct.dto.StorageProductDto;
import com.portfolio.tellmewhenapp.storageProduct.service.StorageProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class MainController {

    StorageProductServiceImpl storageProductService;
    ShoppingProductServiceImpl shoppingProductService;

    @GetMapping("/home")
    public String home(Model model) {
        List<StorageProductDto> storageProductsList = storageProductService.getAll();
        List<ShoppingProductDto> shoppingProductsList = shoppingProductService.getAll();
        List<StorageProductDto> expiredProductsList = storageProductService.getExpiringProducts();

        model.addAttribute("myStorageList", storageProductsList);
        model.addAttribute("myShoppingList", shoppingProductsList);
        model.addAttribute("expiredProductsList", expiredProductsList);

        return "index";
    }

    @GetMapping("/")
    public String goHome(){
        return "redirect:/home";
    }

}
