package com.app.service.impl;

import com.app.dto.UserRegistrationDto;
import com.app.entities.UserRegistration;
import com.app.payload.APIResponse;
import com.app.repository.UserRegistrationRepo;
import com.app.service.UserRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public APIResponse<String> register(UserRegistrationDto dto) {
        APIResponse<String> response = new APIResponse<>();

        if (userRepository.existsByUsername(dto.getUsername())) {
            response.setMessage("Registration Failed");
            response.setStatus(500);
            response.setData("User with username exists");
            return response;
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            response.setMessage("Registration Failed");
            response.setStatus(500);
            response.setData("User with Email Id exists");
            return response;
        }

        UserRegistration user = new UserRegistration();
        BeanUtils.copyProperties(dto, user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        response.setMessage("Registration Done");
        response.setStatus(201);
        response.setData("User is registered");
        return response;
    }
}
