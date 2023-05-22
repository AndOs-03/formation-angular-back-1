package com.andos.projet_produit_core.sercurity;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

/**
 * <p></p>
 *
 * @author Anderson Ouattara 2023-05-18
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

        .cors().configurationSource(request -> {
          var config = new CorsConfiguration();
          config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
          config.setAllowedMethods(Collections.singletonList("*"));
          config.setAllowCredentials(true);
          config.setAllowedHeaders(Collections.singletonList("*"));
          config.setExposedHeaders(Arrays.asList("Authorization"));
          config.setMaxAge(3600L);
          return config;
        }).and()

        .authorizeHttpRequests()
        .anyRequest().permitAll();

        /*
        .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER")
        .requestMatchers(HttpMethod.GET, "/api/getbyid/**").hasAnyAuthority("ADMIN")
        .anyRequest().authenticated().and()
        .addFilterBefore(new JWTAuthorizationFilter(), BasicAuthenticationFilter.class);*/
    return http.build();
  }
}
