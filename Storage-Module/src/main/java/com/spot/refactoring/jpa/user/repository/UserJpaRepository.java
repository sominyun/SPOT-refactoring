package com.spot.refactoring.jpa.user.repository;

import com.spot.refactoring.jpa.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
