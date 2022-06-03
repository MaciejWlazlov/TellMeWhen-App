package com.portfolio.TellMeWhenApp.User.Service;

import com.portfolio.TellMeWhenApp.User.Entity.User;
import com.portfolio.TellMeWhenApp.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public static final Logger LOGGER = LogManager.getLogger(MyUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            LOGGER.warn("User doesn't exist");
            throw new UsernameNotFoundException(username);
        }
        LOGGER.info("Logged in as: " + username);
        return user.get();

    }
}
