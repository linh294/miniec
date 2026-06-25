package com.example.miniec.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public Object profile(Authentication authentication) {
        System.out.println("USER CONTROLLER HIT");
        System.out.println(authentication);
        return authentication;
    }
}
