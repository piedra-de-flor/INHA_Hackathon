package com.example.INHA_Hackathon.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MileageUseRequestDto {
    private final String id;
    private final long mileage;

    @Builder
    public MileageUseRequestDto(String id, long mileage) {
        this.id = id;
        this.mileage = mileage;
    }
}
