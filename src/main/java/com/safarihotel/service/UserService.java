package com.safarihotel.service;

import com.safarihotel.dao.JdbcUserRepository;
import com.safarihotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Component
public class UserService implements UserDetailsService {

    private final JdbcUserRepository userRepository;

    @Autowired
    public UserService(JdbcUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(this.userRepository.findByUsername(username));

        if (user.isPresent())
            return user.get();
        throw new UsernameNotFoundException("Utilisateur ["+username+"] introuvable");
    }
}
