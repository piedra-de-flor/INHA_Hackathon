package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.domain.User;
import com.example.INHA_Hackathon.domain.repository.UserRepository;
import com.example.INHA_Hackathon.dto.ModifyUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ModifyUserService {
    private final UserRepository userRepository;

    @Transactional
    public void endTrip(ModifyUserRequestDto modifyUserRequestDto) {
        Optional<User> user = userRepository.findById(modifyUserRequestDto.getId());
        long distance = modifyUserRequestDto.getDistance();

        user.ifPresent(value -> value.addTotalDistance(distance));
        user.ifPresent(value -> value.addMileage(calMileage(distance)));
    }

    private long calMileage(long distance) {
        return distance / 500;
    }
}
