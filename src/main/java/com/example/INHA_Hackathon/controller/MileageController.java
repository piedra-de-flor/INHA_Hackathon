package com.example.INHA_Hackathon.controller;

import com.example.INHA_Hackathon.dto.LoginRequestDto;
import com.example.INHA_Hackathon.dto.LoginResponseDto;
import com.example.INHA_Hackathon.dto.MileageSaveRequestDto;
import com.example.INHA_Hackathon.dto.MileageSaveResponseDto;
import com.example.INHA_Hackathon.service.ModifyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MileageController {
    private final ModifyUserService mileageService;

    @PostMapping("/plusMileage")
    public MileageSaveResponseDto login(@RequestBody MileageSaveRequestDto mileageSaveRequestDto) {
        return mileageService.saveMileage(mileageSaveRequestDto);
    }
}
