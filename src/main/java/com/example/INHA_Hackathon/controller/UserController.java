package com.example.INHA_Hackathon.controller;

import com.example.INHA_Hackathon.domain.User;
import com.example.INHA_Hackathon.dto.*;
import com.example.INHA_Hackathon.service.JoinService;
import com.example.INHA_Hackathon.service.LoginService;
import com.example.INHA_Hackathon.service.ModifyUserService;
import com.example.INHA_Hackathon.service.UserFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final LoginService loginService;
    private final JoinService joinService;
    private final UserFindService userFindService;
    private final ModifyUserService modifyUserService;

    @PostMapping("/login")
    public UserInfoResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return loginService.login(loginRequestDto);
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinRequestDto joinRequestDto) {
        return joinService.join(joinRequestDto);
    }

    @GetMapping("/userList")
    public List<User> getUserList() {
        return userFindService.getAllUser();
    }

    @GetMapping("/get/user/{id}")
    public UserInfoResponseDto getUser(@PathVariable String id) {
        return new UserInfoResponseDto(userFindService.findUser(id));
    }

    @GetMapping("/update/rank")
    public List<User> updateUserLevel() {
        modifyUserService.updateUserLevel();
        return getUserList();
    }

    @GetMapping("/reset/rank")
    public List<User> resetUserLevel() {
        modifyUserService.resetUserLevel();
        return getUserList();
    }

    @PostMapping("/use/mileage")
    public MileageUseResponseDto useMileage(MileageUseRequestDto mileageUseRequestDto) {
        return modifyUserService.useMileage(mileageUseRequestDto);
    }
}
