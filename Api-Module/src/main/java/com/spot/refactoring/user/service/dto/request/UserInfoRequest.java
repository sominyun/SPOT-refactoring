package com.spot.refactoring.user.service.dto.request;

import com.spot.refactoring.user.constant.Gender;
import com.spot.refactoring.user.constant.Interest;
import com.spot.refactoring.user.constant.Mbti;
import com.spot.refactoring.user.entity.User;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

public record UserInfoRequest(
        @Pattern(regexp = "^[a-zA-Z0-9가-힣_]{1,15}$", message = "공백없이 15자 이하로 작성해주세요 특수문자는 _만 사용 가능해요")
        String nickname,
        String phoneNumber,
        LocalDate birthDay,
        Gender gender,
        Mbti mbti,
        List<Interest> interests
) {
    public User toDomain() {
        return User.of(
                nickname,
                phoneNumber,
                birthDay,
                gender,
                mbti,
                interests
        );
    }
}