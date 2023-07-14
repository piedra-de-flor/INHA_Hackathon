package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.domain.User;
import com.example.INHA_Hackathon.domain.repository.UserRepository;
import com.example.INHA_Hackathon.dto.MileageUseRequestDto;
import com.example.INHA_Hackathon.dto.MileageUseResponseDto;
import com.example.INHA_Hackathon.dto.ModifyUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ModifyUserService {
    private final int MINIMUM_MILEAGE = 0;
    private final UserRepository userRepository;

    @Transactional
    public void endTrip(ModifyUserRequestDto modifyUserRequestDto) {
        Optional<User> user = userRepository.findById(modifyUserRequestDto.getId());
        long distance = modifyUserRequestDto.getDistance();

        user.ifPresent(value -> value.addTotalDistance(distance));
        user.ifPresent(value -> value.addMileage(calMileage(user.get(), distance)));
    }

    private long calMileage(User user,long distance) {
        return switch (user.getLevel()) {
            case "Bronze" -> distance / 500;
            case "Silver" -> distance / 470;
            case "Gold" -> distance / 420;
            case "Diamond" -> distance / 350;
            case "VIP" -> distance / 250;
            default -> 0;
        };
    }

    public void updateUserLevel() {
        userRepository.findAll().stream()
                .filter(user -> user.getTotalDistance() > 500)
                .forEach(user -> user.setLevel("Bronze"));

        userRepository.findAll().stream()
                .filter(user -> user.getTotalDistance() > 1000)
                .forEach(user -> user.setLevel("Silver"));

        userRepository.findAll().stream()
                .filter(user -> user.getTotalDistance() > 2000)
                .forEach(user -> user.setLevel("Gold"));

        userRepository.findAll().stream()
                .filter(user -> user.getTotalDistance() > 4000)
                .forEach(user -> user.setLevel("Diamond"));

        userRepository.findAll().stream()
                .filter(user -> user.getTotalDistance() > 7500)
                .forEach(user -> user.setLevel("VIP"));
    }

    public void resetUserLevel() {
        userRepository.findAll()
                .forEach(user -> user.setLevel("Bronze"));
    }

    public MileageUseResponseDto useMileage(MileageUseRequestDto mileageUseRequestDto) {
        MileageUseResponseDto mileageUseResponseDto = null;
        Optional<User> user = userRepository.findById(mileageUseRequestDto.getId());

        if (user.isPresent()) {
            long currentMileage = user.get().getMileage();

            if (user.get().getMileage() - mileageUseRequestDto.getMileage() > MINIMUM_MILEAGE) {
                user.get().setMileage(currentMileage - mileageUseRequestDto.getMileage());
                mileageUseResponseDto = new MileageUseResponseDto(user.get(), "결제 성공");
            }
            else {
                mileageUseResponseDto = new MileageUseResponseDto(user.get(), "결제 실패, 마일리지가 부족합니다.");
            }
        }
        return mileageUseResponseDto;
    }
}
