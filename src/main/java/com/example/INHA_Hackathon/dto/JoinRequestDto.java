package com.example.INHA_Hackathon.dto;

import com.example.INHA_Hackathon.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinRequestDto {
    private String id;
    private String password;
    private String userName;

    @Builder
    public JoinRequestDto(String id, String password, String userName) {
        this.id = id;
        this.password = password;
        this.userName = userName;
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .userName(userName)
                .build();
    }
}
