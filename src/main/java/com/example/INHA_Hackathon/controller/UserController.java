package com.example.INHA_Hackathon.controller;

import com.example.INHA_Hackathon.dto.JoinRequestDto;
import com.example.INHA_Hackathon.dto.LoginRequestDto;
import com.example.INHA_Hackathon.dto.LoginResponseDto;
import com.example.INHA_Hackathon.service.JoinService;
import com.example.INHA_Hackathon.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final LoginService loginService;
    private final JoinService joinService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return loginService.login(loginRequestDto);
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinRequestDto joinRequestDto) {
        return joinService.join(joinRequestDto);
    }
}