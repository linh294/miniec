package com.example.miniec.service;

import com.example.miniec.entity.User;
import com.example.miniec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String login(String username, String password) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

        System.out.println("RAW: " + password);
        System.out.println("DB : " + user.getPassword());
        System.out.println(passwordEncoder.matches(password, user.getPassword()));

        boolean match = passwordEncoder.matches(password, user.getPassword());

        System.out.println("MATCH RESULT: " + match);

        if (!match) {
            throw new BadCredentialsException("Invalid username or password");
        }
        return jwtService.generateToken(username);
    }
}
