package com.bridgelabz.quantity_measurement_app.auth;

import com.bridgelabz.quantity_measurement_app.security.JwtUtil;
import com.bridgelabz.quantity_measurement_app.user.User;
import com.bridgelabz.quantity_measurement_app.user.UserService;
import org.springframework.web.bind.annotation.*;

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
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        userService.login(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtUtil.generateToken(authRequest.getEmail());
        return new AuthResponse(token);
    }
}