package com.portfolio.TellMeWhenApp.ShoppingList.Controller;

import com.portfolio.TellMeWhenApp.Mapper.ShoppingProductMapper;
import com.portfolio.TellMeWhenApp.ShoppingList.Dto.ShoppingProductDto;
import com.portfolio.TellMeWhenApp.ShoppingList.Service.ShoppingProductServiceImpl;
import com.portfolio.TellMeWhenApp.StorageProduct.Service.StorageProductServiceImpl;
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
public class ShoppingListController {

    public static final Logger LOGGER = LogManager.getLogger(ShoppingListController.class);

    ShoppingProductServiceImpl shoppingProductService;
    StorageProductServiceImpl storageProductService;
    ShoppingProductMapper productMapper;

    @GetMapping("/newPurchase")
    public String newPurchase(@ModelAttribute("productDto") ShoppingProductDto shoppingProductDto, Model model) {
        LOGGER.info("New purchase model added to the view");
        return "addNewPrpoductToShopingList";
    }

    @PostMapping("/addPurchase")
    public String addProduct(@ModelAttribute("productDto") @Valid ShoppingProductDto shoppingProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            LOGGER.warn("Errors in the fields");
            return "addNewPrpoductToShopingList";
        } else {
            shoppingProductService.save(shoppingProductDto);
            LOGGER.info("Saved new purchase to the shopping list successfully");
        }
        return "ShoppingListProductSaveSuccess";
    }

    @GetMapping("/myShoppingList")
    public String showAllProducts(Model model) {

        List<ShoppingProductDto> listOfShoppingProductDto = shoppingProductService.getAll();
        model.addAttribute("listOfShoppingProductDto", listOfShoppingProductDto);

        LOGGER.info("Successfully loaded all purchases");
        return "myShoppingList";
    }

    @GetMapping("/addToStorage")
    public String editProduct(@RequestParam("id") Integer id, Model model) {

        ShoppingProductDto productToBeAdded = shoppingProductService.findOne(id);
        storageProductService.save(productMapper.mapShoppingDtoToStorageProductDto(productToBeAdded));
        shoppingProductService.delete(productToBeAdded.id());

        model.addAttribute("productToBeAdded", productToBeAdded);

        LOGGER.info("Edited product model added to the view");
        return "redirect:myShoppingList";
    }
}
