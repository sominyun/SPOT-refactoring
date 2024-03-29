package com.spot.refactoring.user.repository;

import com.spot.refactoring.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<User> findById(Long userId);
    User save(User user);
}
