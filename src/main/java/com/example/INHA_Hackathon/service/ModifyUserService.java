package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.domain.User;
import com.example.INHA_Hackathon.domain.repository.UserRepository;
import com.example.INHA_Hackathon.dto.MileageSaveRequestDto;
import com.example.INHA_Hackathon.dto.MileageSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ModifyUserService {
    private UserRepository userRepository;

    @Transactional
    public MileageSaveResponseDto saveMileage(MileageSaveRequestDto mileageSaveRequestDto) {
        Optional<User> user = userRepository.findById(mileageSaveRequestDto.getUserid());
        return new MileageSaveResponseDto(user.get());
    }
}
