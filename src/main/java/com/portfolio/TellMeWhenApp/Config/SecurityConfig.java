package com.portfolio.TellMeWhenApp.Config;

import com.portfolio.TellMeWhenApp.User.Service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String HOME_PAGE = "/";
    private static final String LOGIN_PAGE = "/sign-up";

    MyUserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests()
                .antMatchers(HOME_PAGE)
                .authenticated()
                .and()
                .formLogin()
                .loginPage(LOGIN_PAGE).permitAll();
    }

}
