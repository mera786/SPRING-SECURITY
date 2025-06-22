package com.app.service;

import com.app.dto.UserRegistrationDto;
import com.app.payload.APIResponse;

public interface UserRegistrationService {
    APIResponse<String> registration(UserRegistrationDto dto);
}
