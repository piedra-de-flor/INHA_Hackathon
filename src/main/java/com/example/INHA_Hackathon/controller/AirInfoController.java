package com.example.INHA_Hackathon.controller;

import com.example.INHA_Hackathon.dto.GetAirInfoResponseDto;
import com.example.INHA_Hackathon.service.AirConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class AirInfoController {
    private final AirConditionService airConditionService;

    @GetMapping("/airInfo")
    public GetAirInfoResponseDto getAirInfo() throws IOException {
        return airConditionService.getAirInfo();
    }
}
