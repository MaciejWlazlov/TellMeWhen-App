package com.portfolio.tellmewhenapp.user.service;

import com.portfolio.tellmewhenapp.service.IUserService;
import com.portfolio.tellmewhenapp.user.dto.UserDto;
import com.portfolio.tellmewhenapp.user.entity.User;
import com.portfolio.tellmewhenapp.user.repository.UserRepository;
import com.portfolio.tellmewhenapp.utilities.exceptions.UserAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService implements IUserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail()) || usernameExists(userDto.getUsername())) {
            throw new UserAlreadyExistException("There is already an account with that email address or username");
        }

        final User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail((userDto.getEmail()).toUpperCase());
        user.setRole("USER");

        return userRepository.save(user);
    }

    private Boolean emailExists(String email) {
        return userRepository.findByEmail(email.toUpperCase()) != null;
    }

    private Boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
