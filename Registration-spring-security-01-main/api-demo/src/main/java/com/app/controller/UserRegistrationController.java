package com.app.controller;

import com.app.dto.UserRegistrationDto;
import com.app.payload.APIResponse;
import com.app.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userService;


    @PostMapping("/register")
    public ResponseEntity<APIResponse<String>> userRegistration(@RequestBody UserRegistrationDto userRegDto){
        APIResponse<String> apiResponse = userService.registration(userRegDto);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

}
