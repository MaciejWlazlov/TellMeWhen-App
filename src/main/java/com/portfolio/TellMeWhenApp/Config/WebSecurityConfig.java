package com.portfolio.TellMeWhenApp.Config;

import com.portfolio.TellMeWhenApp.User.Service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String HOME_PAGE = "/home";
    private static final String LOGIN_PAGE = "/auth/login";
    private static final String LOGOUT_PAGE = "/auth/logout";
    MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http
                .authorizeRequests()
                .antMatchers("/storage").authenticated()
                .and()
                .formLogin()
                .loginPage(LOGIN_PAGE)
                .defaultSuccessUrl(HOME_PAGE)
                .and()
                .logout()
                .logoutUrl(LOGOUT_PAGE)
                .logoutSuccessUrl("/auth/login?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
    }
}
