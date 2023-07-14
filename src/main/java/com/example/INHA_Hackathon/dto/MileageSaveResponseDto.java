package com.example.INHA_Hackathon.dto;

import com.example.INHA_Hackathon.domain.User;
import lombok.Builder;

public class MileageSaveResponseDto {
    private final String id;
    private final String password;
    private final String userName;
    private final String level;
    private final long totalDistance;
    private final long mileage;

    @Builder
    public MileageSaveResponseDto(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.userName = user.getUserName();
        this.level = user.getLevel();
        this.totalDistance = user.getTotalDistance();
        this.mileage = user.getMileage();
    }
}
