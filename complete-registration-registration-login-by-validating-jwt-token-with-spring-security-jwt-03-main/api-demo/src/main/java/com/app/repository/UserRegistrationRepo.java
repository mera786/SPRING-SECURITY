package com.app.repository;

import com.app.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepo extends JpaRepository<UserRegistration,Long> {

    UserRegistration findByUsername(String username);
    UserRegistration findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
