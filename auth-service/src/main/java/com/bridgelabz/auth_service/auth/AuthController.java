package com.bridgelabz.auth_service.auth;

import com.bridgelabz.auth_service.dto.RegisterRequest;
import com.bridgelabz.auth_service.security.JwtUtil;
import com.bridgelabz.auth_service.user.User;
import com.bridgelabz.auth_service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,  JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        userService.login(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtUtil.generateToken(authRequest.getEmail());
        return new AuthResponse(token);
    }
}