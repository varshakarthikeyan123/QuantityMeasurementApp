package com.bridgelabz.service;

import com.bridgelabz.dto.*;
import com.bridgelabz.entity.*;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;

    // ✅ Constructor FIX
    public AuthService(UserRepository repo,
                       JwtService jwtService,
                       PasswordEncoder encoder) {
        this.repo = repo;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    public String register(RegisterRequest req) {
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        repo.save(user);
        return "User Registered";
    }

    public AuthResponse login(AuthRequest req) {
        User user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}