package com.app.controller;

import com.app.dto.LoginDto;
import com.app.payload.APIResponse;
import com.app.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/user")
public class UserLoginController {


    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> loginCheck(@RequestBody LoginDto dto) {
        APIResponse<String> response = new APIResponse<>();

        // ✅ Hardcoded check instead of DB
        if ("mike".equals(dto.getUsername()) && "testing".equals(dto.getPassword())) {
            String token = jwtService.generateToken(dto.getUsername(), "ROLE_USER");

            response.setStatus(200);
            response.setMessage("Login Successful");
            response.setData(token);
            return ResponseEntity.ok(response);
        }

        response.setStatus(401);
        response.setMessage("Invalid credentials");
        response.setData(null);
        return ResponseEntity.status(401).body(response);
    }
}
