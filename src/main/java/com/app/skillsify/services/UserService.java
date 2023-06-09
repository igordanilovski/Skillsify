package com.app.skillsify.services;

import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.AccountDetailsDto;
import com.app.skillsify.models.dto.LoginDto;
import com.app.skillsify.models.dto.RegisterDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> findAll();

    ResponseEntity<?> register(RegisterDto registerDto);

    ResponseEntity<?> authenticate(LoginDto loginDto);

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);

    AccountDetailsDto getUserDetails(String username);
}
