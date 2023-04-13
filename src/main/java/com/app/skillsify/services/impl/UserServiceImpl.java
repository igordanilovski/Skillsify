package com.app.skillsify.services.impl;

import com.app.skillsify.models.User;
import com.app.skillsify.repositories.UserRepository;
import com.app.skillsify.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
