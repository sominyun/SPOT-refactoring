package com.spot.refactoring.jpa.user.repositoryImpl;

import com.spot.refactoring.jpa.user.mapper.UserMapper;
import com.spot.refactoring.jpa.user.repository.UserJpaRepository;
import com.spot.refactoring.user.entity.User;
import com.spot.refactoring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findById(Long userId) {
        return userJpaRepository.findById(userId)
                .map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        return userMapper.toDomain(userJpaRepository.save(userMapper.toEntity(user)));
    }
}
