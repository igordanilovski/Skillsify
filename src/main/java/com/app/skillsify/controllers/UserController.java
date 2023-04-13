package com.app.skillsify.controllers;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.dto.LoginDto;
import com.app.skillsify.models.dto.RegisterDto;
import com.app.skillsify.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> getCourseByName(@RequestBody RegisterDto registerDto) {
        return this.userService.register(registerDto);
    }

    @PostMapping("/login")
    public String getCourseByName(@RequestBody LoginDto loginDto) {
        return this.userService.authenticate(loginDto);
    }
}
