package com.ezidayzi.service;

import com.ezidayzi.model.UserInfo;
import com.ezidayzi.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService() {
        this.repository = new MemberRepository();
    }

    public UserInfo find(String id) {
        return repository.map.get(id);
    }

    public void modify(UserInfo userInfo) {
        repository.map.put(userInfo.getUserid(), userInfo);
        System.out.println(userInfo);
    }

    public void signUp(UserInfo userInfo) {
        repository.map.put(userInfo.getUserid(), userInfo);
        System.out.println(userInfo);
    }

    public void withdraw(String id) {
        repository.map.remove(id);
    }
}
