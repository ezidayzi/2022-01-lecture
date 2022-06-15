package com.ezidayzi.service;


import com.ezidayzi.entity.User;
import com.ezidayzi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void insert(User user) {
        userRepository.insert(user);
    }
}
