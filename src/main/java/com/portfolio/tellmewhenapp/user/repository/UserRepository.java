package com.portfolio.tellmewhenapp.user.repository;

import com.portfolio.tellmewhenapp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);
    User findByEmail(String email);
    User findByUsername(String username);
}
