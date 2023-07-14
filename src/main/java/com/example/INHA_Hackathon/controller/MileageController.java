package com.example.INHA_Hackathon.controller;

import com.example.INHA_Hackathon.dto.ModifyUserRequestDto;
import com.example.INHA_Hackathon.service.ModifyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MileageController {
    private final ModifyUserService mileageService;

    @PostMapping("/endTrip")
    public void addMileage(@RequestBody ModifyUserRequestDto modifyUserRequestDto) {
        mileageService.endTrip(modifyUserRequestDto);
    }
}
