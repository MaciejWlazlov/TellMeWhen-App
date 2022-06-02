package com.portfolio.TellMeWhenApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {

    @GetMapping("/sign-in")
    public String signIn(){
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String submit(){
        return "redirect:/";
    }
}
