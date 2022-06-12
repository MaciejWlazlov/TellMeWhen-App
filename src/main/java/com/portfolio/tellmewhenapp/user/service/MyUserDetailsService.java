package com.portfolio.tellmewhenapp.user.service;

import com.portfolio.tellmewhenapp.user.entity.User;
import com.portfolio.tellmewhenapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public static final Logger LOGGER = LogManager.getLogger(MyUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isEmpty()) {
            LOGGER.warn("User doesn't exist");
            throw new UsernameNotFoundException(username);
        }
        LOGGER.info(MessageFormat.format("Logged in as: {0}", username));
        return user.get();

    }
}
