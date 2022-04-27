package repository;


import entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
User 객체들을 저장하는 repository
 */
public class UserRepository {
    private final Map<String, User> map = new HashMap<>();

    public void insert(User user) {
        map.put(user.getId(), user);
    }

    public void update(User user) {
        map.put(user.getId(), user);
    }

    public User delete(String id) {
        return map.remove(id);
    }

    public User read(String id) {
        return map.get(id);
    }

    public Collection<User> selectAll() {
        return map.values();
    }
}
