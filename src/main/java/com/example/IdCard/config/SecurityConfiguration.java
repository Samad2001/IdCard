package com.example.IdCard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }



    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin =
                User.withUsername("admin")
                        .password(passwordEncoder().encode("Sem@2024"))
                        .build();

        UserDetails user =
                User.withUsername("user")
                        .password(passwordEncoder().encode("user2024"))
                        .build();
        return  new InMemoryUserDetailsManager(admin,user);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
      return   http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(
                        authManager-> authManager.
                                requestMatchers("/id-cards/no-auth", "id-cards/no-auth/id/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .build();
    }


}
