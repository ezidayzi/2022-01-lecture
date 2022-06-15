package com.zzin.realfinal.repository;

import com.zzin.realfinal.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberRepository {
    public HashMap<String, UserInfo> map = new HashMap<>();
}
