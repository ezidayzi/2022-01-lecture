package com.ezidayzi.repository;

import com.ezidayzi.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberRepository {
    public HashMap<String, UserInfo> map = new HashMap<>();
}
