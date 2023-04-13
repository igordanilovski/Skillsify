package com.app.skillsify.services.impl;

import com.app.skillsify.jwtUtils.JwtUtilities;
import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.LoginDto;
import com.app.skillsify.models.dto.RegisterDto;
import com.app.skillsify.models.enumerations.Role;
import com.app.skillsify.repositories.UserRepository;
import com.app.skillsify.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtilities jwtUtilities;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtilities jwtUtilities) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtilities = jwtUtilities;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        User user = new User();

        String generatedUsernameFromFirstAndLastName = (registerDto.getFirstName().toLowerCase() + registerDto.getLastName()).toLowerCase().replaceAll("[^a-z0-9-]", "");

        user.setEmail(registerDto.getEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setUsername(generatedUsernameFromFirstAndLastName);
        user.setCreatedAt(new Date());
        user.setPassword(this.passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(Role.STANDARD); //Default
        userRepository.save(user);

        //String token = jwtUtilities.generateToken(registerDto.getEmail(), "");
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @Override
    public String authenticate(LoginDto loginDto) {
        return "";
    }
}
