package com.example.INHA_Hackathon.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ModifyUserRequestDto {
    private final String id;
    private final long distance;

    @Builder
    public ModifyUserRequestDto(String id, long distance) {
        this.id = id;
        this.distance = distance;
    }
}
