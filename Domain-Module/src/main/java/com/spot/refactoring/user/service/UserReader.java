package com.spot.refactoring.user.service;

import com.spot.refactoring.user.entity.User;
import com.spot.refactoring.user.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReader {
    private final UserRepository userRepository;

    public User getUser(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }
}
