package com.example.tester.repo;

import com.example.tester.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
