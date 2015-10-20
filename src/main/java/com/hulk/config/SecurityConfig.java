package com.hulk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by vijayvar on 10/17/15.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                        .failureUrl("/login?error")
                        .usernameParameter("username")
                        .permitAll()
                        .and()
                    .logout()
                        .logoutUrl("/logout")
                        .deleteCookies("remember-me")
                        .logoutSuccessUrl("/")
                        .permitAll()
                        .and()
                    .rememberMe()
                    .and()
                .authorizeRequests()
                    .antMatchers("/agents/create", "/assets/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .csrf().disable()
        ;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
