package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.domain.User;
import com.example.INHA_Hackathon.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserFindService {
    private final UserRepository userRepository;

    @Transactional
    public User findUser(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(() -> new User("아이디가 존재하지 않습니다.", "-", "-"));
    }

    @Transactional
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
