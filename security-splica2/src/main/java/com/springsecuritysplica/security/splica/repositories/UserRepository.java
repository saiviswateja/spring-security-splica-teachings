package com.springsecuritysplica.security.splica.repositories;


import com.springsecuritysplica.security.splica.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
