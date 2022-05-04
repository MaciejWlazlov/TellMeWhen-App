package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.StorageProduct.Service.StorageProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/home")
    public String returnHome() {
        return "index";
    }

}
