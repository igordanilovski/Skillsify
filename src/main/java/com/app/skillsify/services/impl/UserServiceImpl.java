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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtilities jwtUtilities;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtilities jwtUtilities, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtilities = jwtUtilities;
        this.authenticationManager = authenticationManager;
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

        List<String> rolesNames = new ArrayList<>();
        rolesNames.add(user.getRole().name());

        String token = jwtUtilities.generateToken(registerDto.getEmail(), rolesNames);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> authenticate(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<String> rolesNames = new ArrayList<>();
        rolesNames.add(user.getRole().name());

        String token = jwtUtilities.generateToken(user.getUsername(), rolesNames);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow();
    }
}
