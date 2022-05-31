package com.portfolio.TellMeWhenApp.User.Service;

import com.portfolio.TellMeWhenApp.User.Entity.User;
import com.portfolio.TellMeWhenApp.User.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setEmail(user.getEmail());
        userRepository.save(user);
    }
}
