package com.example.INHA_Hackathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String id;
    private String password;
    private String userName;
    private String level = "unRanked";
    private long totalDistance = 0;
    private long mileage = 0;

    public void addMileage(long mileage) {
        this.mileage += mileage;
    }

    public void addTotalDistance(long distance) {
        this.totalDistance += distance;
    }

    @Builder
    public User(String id, String password, String userName) {
        this.id = id;
        this.password = password;
        this.userName = userName;
    }
}
