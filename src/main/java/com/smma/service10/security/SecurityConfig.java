package com.smma.service10.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity; enable and configure it properly in production
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page URL
                        .permitAll() // Allow everyone to access the login page
                )
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/categoriesList", "/deleteCategorie", "/createCategorie", "/showCategorie", "/saveCategorie", "/updateCategorie", "/productsList", "/createProduct", "/deleteProduct", "/saveProduct", "/showProduct", "/updateProduct")
                        .authenticated()
                        .anyRequest().permitAll() // Allow public access to all other endpoints
                )
                .exceptionHandling(e->e.accessDeniedPage("/accessDenied"))
                .build();
    }

    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(bCryptPasswordEncoder().encode("admin"))
                        .roles("ADMIN")
                        .build()
        );
    }
}
