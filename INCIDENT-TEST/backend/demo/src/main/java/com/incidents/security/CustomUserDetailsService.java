package com.incidents.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new User(
                "admin",
                "$2a$10$DowJonesIndex123456789012345678901234567890123456",
                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}