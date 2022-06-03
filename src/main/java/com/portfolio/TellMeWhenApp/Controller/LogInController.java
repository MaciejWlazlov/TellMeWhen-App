package com.portfolio.TellMeWhenApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogInController {

    @GetMapping("/auth/login")
    public String signIn(){
        return "login";
    }

    @PostMapping("/auth/login")
    public String submit() {
        return "index";
    }
}
