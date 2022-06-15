package com.zzin.realfinal.service;

import com.zzin.realfinal.entities.User;
import com.zzin.realfinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void insert(User user) {
        userRepository.insert(user);
    }

    public User find(String id) {
        return userRepository.findOne(id);
    }

    public void modify(User user) {
        User isUser = userRepository.findOne(user.getUserId());
        isUser.setEmail(user.getEmail());
        isUser.setBirthday(user.getBirthday());
        isUser.setAddr(user.getAddr());
        isUser.setTel(user.getTel());
    }

    public void withdraw(User user) {
        userRepository.remove(user);
    }
}
