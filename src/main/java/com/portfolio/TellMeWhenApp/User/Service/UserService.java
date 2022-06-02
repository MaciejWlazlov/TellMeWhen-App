package com.portfolio.TellMeWhenApp.User.Service;

import com.portfolio.TellMeWhenApp.User.Entity.User;
import com.portfolio.TellMeWhenApp.User.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setEmail(user.getEmail());
        userRepository.save(user);
    }
}
