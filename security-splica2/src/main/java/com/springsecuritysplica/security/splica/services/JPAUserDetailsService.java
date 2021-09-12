package com.springsecuritysplica.security.splica.services;

import com.springsecuritysplica.security.splica.entities.User;
import com.springsecuritysplica.security.splica.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);

        User u = user.orElseThrow(()->new UsernameNotFoundException("Cannot find the user details!"));
        return new SecurityUser(u);
    }
}
