package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.ShoppingList.Dto.ShoppingProductDto;
import com.portfolio.TellMeWhenApp.ShoppingList.Service.ShoppingProductServiceImpl;
import com.portfolio.TellMeWhenApp.StorageProduct.Dto.StorageProductDto;
import com.portfolio.TellMeWhenApp.StorageProduct.Service.StorageProductServiceImpl;
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

        System.out.println(expiredProductsList);

        return "index";
    }

    @GetMapping("/")
    public String goHome(){
        return "redirect:/home";
    }

}
