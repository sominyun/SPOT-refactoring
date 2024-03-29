package com.spot.refactoring.user.service;


import com.spot.refactoring.user.service.dto.UserInfoDto;
import com.spot.refactoring.user.service.dto.request.UpdateUserInfoRequest;
import com.spot.refactoring.user.service.dto.request.UserInfoRequest;
import com.spot.refactoring.user.service.dto.response.UserInfoResponse;

public interface UserInfoService {
    UserInfoResponse fillUserInfo(UserInfoRequest userInfoRequest);

    UserInfoDto getUserInfo(Long userId);

    UserInfoResponse updateUserInfo(Long userId, UpdateUserInfoRequest updateUserInfoRequest);

}
