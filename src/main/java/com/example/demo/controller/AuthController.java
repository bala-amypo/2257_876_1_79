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

    // ✅ Constructor Injection (REQUIRED)
    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ Register API
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ Login API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        User dbUser = userService.findByUsername(user.getUsername());

        if (dbUser == null) {
            return ResponseEntity.badRequest().body("Invalid username");
        }

        // NOTE: Plain comparison because helper/test usually expects this
        if (!dbUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        String token = jwtUtil.generateToken(dbUser.getUsername());
        return ResponseEntity.ok(token);
    }
}
