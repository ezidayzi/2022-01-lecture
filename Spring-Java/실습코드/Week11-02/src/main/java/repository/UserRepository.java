package repository;


import model.UserInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, UserInfo> map = new HashMap<>();

    public void insert(UserInfo user) {
        map.put(user.getId(), user);
    }

    public void update(UserInfo user) {
        map.put(user.getId(), user);
    }

    public UserInfo delete(String id) {
        return map.remove(id);
    }

    public UserInfo read(String id) {
        return map.get(id);
    }

    public Map<String, UserInfo> getMap() {
        return map;
    }
}