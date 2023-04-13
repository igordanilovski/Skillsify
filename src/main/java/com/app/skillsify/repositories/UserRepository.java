package com.app.skillsify.repositories;

import com.app.skillsify.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
