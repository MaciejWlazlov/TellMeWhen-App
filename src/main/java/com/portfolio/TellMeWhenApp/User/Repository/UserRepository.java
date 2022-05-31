package com.portfolio.TellMeWhenApp.User.Repository;

import com.portfolio.TellMeWhenApp.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
