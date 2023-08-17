package com.manojboot.infy.basicspringsecurity;

import com.fasterxml.jackson.databind.annotation.NoClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.naming.NoPermissionException;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("manojboot").password("password").roles("USER");
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.
                    csrf()
                    .disable();
            http.antMatcher("/api/v1/greetings/hello")
                    .authorizeRequests()
                    .anyRequest()
                    .fullyAuthenticated()
                    .and()
                    .httpBasic();
        }
        @Bean
        public static NoOpPasswordEncoder passwordEncoder(){
            return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }
}
