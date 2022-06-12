package com.portfolio.tellmewhenapp.user.controller;

import com.portfolio.tellmewhenapp.user.dto.UserDto;
import com.portfolio.tellmewhenapp.user.service.UserService;
import com.portfolio.tellmewhenapp.utilities.exceptions.UserAlreadyExistException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    UserService userService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(@ModelAttribute("user") UserDto userDto) {
        LOGGER.debug("Rendering registration page.");
        return "registration";
    }

    @PostMapping("/user/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto) {
        try {
            userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException ex) {
            LOGGER.warn(ex.getMessage());
            return "registration";
        }
        LOGGER.info("Saved new user to the database successfully");
        return "successRegister";
    }
}