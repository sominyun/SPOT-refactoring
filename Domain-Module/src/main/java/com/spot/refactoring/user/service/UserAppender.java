package com.spot.refactoring.user.service;

import com.spot.refactoring.user.entity.User;
import com.spot.refactoring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAppender {
    private final UserRepository userRepository;

    public User append(User newUser){
        return userRepository.save(newUser);
    }
}
