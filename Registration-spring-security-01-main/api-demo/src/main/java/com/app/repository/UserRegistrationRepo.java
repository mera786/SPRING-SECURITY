package com.app.repository;

import com.app.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepo extends JpaRepository<UserRegistration,Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);


}
