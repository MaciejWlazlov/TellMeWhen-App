package com.portfolio.TellMeWhenApp.Config;

import com.portfolio.TellMeWhenApp.User.Service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private static final String HOME_PAGE = "/home";
    private static final String LOGIN_PAGE = "/auth/login";
    MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/myStorage", "/myShoppingList")
                        .authenticated()
                )
                .formLogin(form -> form
                        .loginPage(LOGIN_PAGE)
                        .permitAll()
                        .defaultSuccessUrl(HOME_PAGE)
                );
        return http.build();
    }
}
