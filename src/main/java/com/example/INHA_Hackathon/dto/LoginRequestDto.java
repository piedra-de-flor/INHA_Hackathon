package com.example.INHA_Hackathon.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    private final String id;
    private final String password;

    @Builder
    public LoginRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
