package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.domain.User;
import com.example.INHA_Hackathon.domain.repository.UserRepository;
import com.example.INHA_Hackathon.dto.LoginRequestDto;
import com.example.INHA_Hackathon.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    @Transactional
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Optional<User> user = userRepository.findById(loginRequestDto.getId());
        User wrongPassword = new User("비밀번호가 틀립니다.", "-", "-");
        User wrongId = new User("아이디가 존재하지 않습니다.", "-", "-");
        if (user.isPresent()) {
            if (user.get().getPassword().equals(loginRequestDto.getPassword())) {
                return new LoginResponseDto(user.get());
            } else {
                return new LoginResponseDto(wrongPassword);
            }
        } else {
            return new LoginResponseDto(wrongId);
        }
    }
}
