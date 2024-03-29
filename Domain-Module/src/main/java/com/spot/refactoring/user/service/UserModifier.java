package com.spot.refactoring.user.service;

import com.spot.refactoring.user.entity.User;
import com.spot.refactoring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserModifier {
    private final UserRepository userRepository;

    public User update(Long userId, User newUser){
        User user = userRepository.findById(userId).orElseThrow();

        user.update(newUser);

        return userRepository.save(user);
    }
}