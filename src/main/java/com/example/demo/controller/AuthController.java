package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ Register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // ✅ Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        User dbUser = userService.findByEmail(user.getEmail());

        if (dbUser == null) {
            return ResponseEntity.badRequest().body("Invalid email");
        }

        if (!dbUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        String token = jwtUtil.generateToken(dbUser.getEmail());
        return ResponseEntity.ok(token);
    }
}
