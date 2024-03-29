package com.spot.refactoring.jpa.user.mapper;

import com.spot.refactoring.jpa.user.entity.UserEntity;
import com.spot.refactoring.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(UserEntity userEntity) {
        return User.toDomain(
                userEntity.getId(),
                userEntity.getLoginType(),
                userEntity.getSocialId(),
                userEntity.getRole(),
                userEntity.getName(),
                userEntity.getProfileImageUrl(),
                userEntity.getNickname(),
                userEntity.getPhoneNumber(),
                userEntity.getBirthDay(),
                userEntity.getGender(),
                userEntity.getMbti(),
                userEntity.getInterests(),
                userEntity.getStatus()
        );
    }
    public UserEntity toEntity(User user) {
        return UserEntity.toEntity(
                user.getId(),
                user.getLoginType(),
                user.getSocialId(),
                user.getRole(),
                user.getName(),
                user.getProfileImageUrl(),
                user.getNickname(),
                user.getPhoneNumber(),
                user.getBirthDay(),
                user.getGender(),
                user.getMbti(),
                user.getInterests(),
                user.getStatus()
        );
    }
}
