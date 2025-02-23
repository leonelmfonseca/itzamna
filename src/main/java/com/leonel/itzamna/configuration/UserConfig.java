package com.leonel.itzamna.configuration;

import com.leonel.itzamna.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {
    
    @Bean
    UserDetailsService userDetailsService() {
    // Builds the user with a given username, password, and authority list
    UserDetails user;
        user = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    
    /*
    - Bcrypt is a cryptographic hash function designed for password hashing and safe storing
    in the backend of applications in a way that is less susceptible to dictionary-based cyberattacks.
    
    - Bcrypt runs a complex hashing process, during which a user’s password is transformed into
    a fixed-length thread of characters.
    
    - It uses a one-way hash function, meaning that once the password is hashed,
    it cannot be reversed to its original form.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
