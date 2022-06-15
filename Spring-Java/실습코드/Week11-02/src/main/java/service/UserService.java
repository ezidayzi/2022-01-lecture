package service;

import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;

import java.util.Map;
import java.util.Map.Entry;


public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserInfo userInfo) {
        System.out.println(userInfo.getName());
        System.out.println(userInfo.getAddress());
        System.out.println(userInfo.getId());
        System.out.println(userInfo.getEmail());
        System.out.println(userInfo.getPhone());
        userRepository.insert(userInfo);
    }

    public UserInfo searchWithEmail(String email) {
        for (UserInfo userInfo : userRepository.getMap().values()) {
            if (userInfo.getEmail().equals(email))
                return  userInfo;
        }

        return null;
    }

    public UserInfo searchWithId(String id) {
        for (UserInfo userInfo : userRepository.getMap().values()) {
            if (userInfo.getId().equals(id))
                return  userInfo;
        }

        return null;
    }

    public UserInfo searchWithPhone(String phone) {
        for (UserInfo userInfo : userRepository.getMap().values()) {
            if (userInfo.getPhone().equals(phone))
                return  userInfo;
        }

        return null;
    }
}