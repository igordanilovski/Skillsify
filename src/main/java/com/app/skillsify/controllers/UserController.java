package com.app.skillsify.controllers;

import com.app.skillsify.models.dto.AccountDetailsDto;
import com.app.skillsify.models.dto.LoginDto;
import com.app.skillsify.models.dto.RegisterDto;
import com.app.skillsify.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        return this.userService.register(registerDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return this.userService.authenticate(loginDto);
    }

    @GetMapping("/account-details/{username}")
    public AccountDetailsDto getUserDetails(@PathVariable String username){
        return this.userService.getUserDetails(username);
    }
}