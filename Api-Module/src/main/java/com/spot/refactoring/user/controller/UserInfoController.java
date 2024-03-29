package com.spot.refactoring.user.controller;

import com.spot.refactoring.user.service.UserInfoService;
import com.spot.refactoring.user.service.dto.request.UpdateUserInfoRequest;
import com.spot.refactoring.user.service.dto.UserInfoDto;
import com.spot.refactoring.user.service.dto.request.UserInfoRequest;
import com.spot.refactoring.user.service.dto.response.UserInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;

    //유저 기본 정보 기입
    @PostMapping("")
    public ResponseEntity<UserInfoResponse> basicInfo(
            @RequestBody @Valid UserInfoRequest userInfoRequest) {
        return ResponseEntity.ok(userInfoService.fillUserInfo(userInfoRequest));
    }

    //유저 정보 조회
    @GetMapping("")
    public ResponseEntity<UserInfoDto> getUserInfo(@RequestParam Long userId) {
        return ResponseEntity.ok(userInfoService.getUserInfo(userId));
    }

    //유저 정보 수정
    @PutMapping("")
    public ResponseEntity<UserInfoResponse> updateUserInfo(
            @RequestParam Long userId,
            @Valid @RequestBody UpdateUserInfoRequest updateUserInfoRequest
    ) {
        return ResponseEntity.ok(userInfoService.updateUserInfo(userId, updateUserInfoRequest));
    }

    @DeleteMapping("")
    public String hello(){
        return "hello";
    }
}
