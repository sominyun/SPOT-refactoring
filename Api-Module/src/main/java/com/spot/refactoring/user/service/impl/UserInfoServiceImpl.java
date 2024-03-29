package com.spot.refactoring.user.service.impl;

import com.spot.refactoring.user.service.UserAppender;
import com.spot.refactoring.user.service.UserInfoService;
import com.spot.refactoring.user.service.UserModifier;
import com.spot.refactoring.user.service.UserReader;
import com.spot.refactoring.user.service.dto.UserInfoDto;
import com.spot.refactoring.user.service.dto.request.UpdateUserInfoRequest;
import com.spot.refactoring.user.service.dto.request.UserInfoRequest;
import com.spot.refactoring.user.service.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserInfoServiceImpl implements UserInfoService {
    private final UserAppender userAppender;
    private final UserReader userReader;
    private final UserModifier userModifier;

    @Transactional
    public UserInfoResponse fillUserInfo(UserInfoRequest userInfoRequest) {
        return UserInfoResponse.from(
                userAppender.append(userInfoRequest.toDomain())
        );
    }

    public UserInfoDto getUserInfo(Long userId) {
        return UserInfoDto.from(
                userReader.getUser(userId)
        );
    }


    @Transactional
    public UserInfoResponse updateUserInfo(Long userId, UpdateUserInfoRequest userInfoRequest) {
        return UserInfoResponse.from(
                userModifier.update(userId, userInfoRequest.toDomain())
                );
    }
}