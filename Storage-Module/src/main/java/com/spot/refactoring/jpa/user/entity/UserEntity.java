package com.spot.refactoring.jpa.user.entity;

import com.spot.refactoring.user.constant.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Entity(name = "user_")
@Builder
@Getter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "login_type", length = 100)
    private OAuthType loginType;

    @Column(name = "social_id")
    private String socialId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "phonen_number", length = 100)
    private String phoneNumber;

    @Column(name = "nickname", length = 100)
    private String nickname;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "mbti", length = 10)
    private Mbti mbti;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "interest", length = 10)
    private List<Interest> interests = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Builder
    public UserEntity(String phoneNumber, OAuthType loginType, String nickname, Gender gender, LocalDate birthDay, Mbti mbti, List interests) {
        this.role = Role.USER;
        this.loginType = loginType;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.gender = gender;
        this.birthDay = birthDay;
        this.mbti = mbti;
        this.interests = interests;
        this.status = Status.PROGRESS;
    }
    public static UserEntity toEntity(Long id,
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
        return new UserEntity(id,loginType,socialId, role,name,profileImageUrl,nickname,phoneNumber,birthDay,gender,mbti,interests,status);
    }
}
