package com.spot.refactoring.user.entity;

import com.spot.refactoring.user.constant.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private Long id;
    private OAuthType loginType;
    private String socialId;
    private Role role;
    private String name;
    private String profileImageUrl;
    private String nickname;
    private String phoneNumber;
    private LocalDate birthDay;
    private Gender gender;
    private Mbti mbti;
    private List<Interest> interests;
    private Status status;

    private User(String nickname, String phoneNumber, LocalDate birthDay, Gender gender, Mbti mbti, List<Interest> interests) {
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
        this.mbti = mbti;
        this.interests = interests;
    }

    public static User of(String nickname,
                          String phoneNumber,
                          LocalDate birthDay,
                          Gender gender,
                          Mbti mbti,
                          List<Interest> interests) {
        return new User(nickname, phoneNumber, birthDay, gender, mbti, interests);
    }

    public static User toDomain(Long id,
                                OAuthType loginType,
                                String socialId,
                                Role role,
                                String name,
                                String profileImageUrl,
                                String nickname,
                                String phoneNumber,
                                LocalDate birthDay,
                                Gender gender,
                                Mbti mbti,
                                List<Interest> interests,
                                Status status
    ) {
        return new User(id,loginType,socialId, role,name,profileImageUrl,nickname,phoneNumber,birthDay,gender,mbti,interests,status);
    }

    public void update(User user) {
        this.nickname = user.getNickname();
        this.phoneNumber = user.getPhoneNumber();
        this.birthDay = user.getBirthDay();
        this.gender = user.getGender();
        this.mbti = user.getMbti();
        this.interests = user.getInterests();
    }

}
