package com.app.skillsify.services.impl;

import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.LoginDto;
import com.app.skillsify.models.dto.RegisterDto;
import com.app.skillsify.models.enumerations.Role;
import com.app.skillsify.repositories.UserRepository;
import com.app.skillsify.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        User user = new User();
        String generatedUsernameFromFirstAndLastName = (registerDto.getFirstName().toLowerCase() + "_" + registerDto.getLastName()).toLowerCase().replaceAll("[^a-z0-9-]", "");

        user.setEmail(registerDto.getEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setUsername(generatedUsernameFromFirstAndLastName);
        user.setPassword(this.passwordEncoder.encode(registerDto.getPassword()));

        //Default this
        user.setRole(Role.STANDARD);
        userRepository.save(user);
        //String token = jwtUtilities.generateToken(registerDto.getEmail());
        return null;
    }

    @Override
    public String authenticate(LoginDto loginDto) {
        return null;
    }
}
