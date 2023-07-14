package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.domain.User;
import com.example.INHA_Hackathon.domain.repository.UserRepository;
import com.example.INHA_Hackathon.dto.JoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JoinService {
    private final UserRepository userRepository;

    @Transactional
    public String join(JoinRequestDto joinRequestDto) {
        Optional<User> user = userRepository.findById(joinRequestDto.getId());

        if (user.isPresent()) {
            return "회원가입 실패";
        } else {
            userRepository.save(joinRequestDto.toEntity());
            return "회원가입 성공";
        }
    }
}
