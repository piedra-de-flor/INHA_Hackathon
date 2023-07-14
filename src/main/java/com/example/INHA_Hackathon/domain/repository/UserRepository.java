package com.example.INHA_Hackathon.domain.repository;

import com.example.INHA_Hackathon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String id);
}
