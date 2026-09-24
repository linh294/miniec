package com.example.miniec.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public Object profile(Authentication authentication) {
        System.out.println("USER CONTROLLER HIT");
        System.out.println(authentication);
//        return authentication;
        System.out.println("Authentication is null: " + (authentication == null));

        Map<String, Object> response = new HashMap<>();

        if (authentication == null) {
            System.out.println("❌ Authentication is NULL - JWT filter not working!");
            response.put("error", "Authentication is null");
            response.put("status", 401);
            return response;
        }

        String username = authentication.getName();
        System.out.println("Username: " + username);
        System.out.println("Principal: " + authentication.getPrincipal());
        System.out.println("Authorities: " + authentication.getAuthorities());

        response.put("username", username);
        response.put("authorities", authentication.getAuthorities());
        response.put("status", 200);

        System.out.println("✅ Response: " + response);
        return response;
    }
}
