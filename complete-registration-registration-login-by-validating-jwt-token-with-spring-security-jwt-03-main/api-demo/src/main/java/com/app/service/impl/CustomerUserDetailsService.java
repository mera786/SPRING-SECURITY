package com.app.service.impl;

import com.app.entities.UserRegistration;
import com.app.repository.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRegistrationRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRegistration user = userRepository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));//This should be modified
    }

}