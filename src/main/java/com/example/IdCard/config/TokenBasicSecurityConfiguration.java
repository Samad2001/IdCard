package com.example.IdCard.config;

import com.example.IdCard.filter.AuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class TokenBasicSecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final AuthorizationFilter  authorizationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
      return   http
              .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authManager-> authManager
                                .requestMatchers("/user/register",
                                                "/user/login",
                                                "/v3/api-docs/**",
                                                "/v3/api-docs.yaml",
                                                "/swagger-ui/**",
                                                "/swagger-ui.html")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
              .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
              .authenticationProvider(authenticationProvider)
              .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
