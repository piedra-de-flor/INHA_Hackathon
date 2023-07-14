package com.example.INHA_Hackathon.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MileageSaveRequestDto {
    private String userid;
    private long distance;

    @Builder
    public MileageSaveRequestDto(String userid, long distance) {
        this.userid = userid;
        this.distance = distance;
    }
}
