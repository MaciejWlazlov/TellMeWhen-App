package com.portfolio.TellMeWhenApp.User.Controller;

import com.portfolio.TellMeWhenApp.User.Entity.User;
import com.portfolio.TellMeWhenApp.User.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(User user) {
        userService.addUser(user);

        return "register";
    }
}
