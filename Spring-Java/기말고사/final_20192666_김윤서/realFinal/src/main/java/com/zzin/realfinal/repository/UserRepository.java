package com.zzin.realfinal.repository;

import com.zzin.realfinal.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    @Transactional
    public void insert(User user) {
        em.persist(user);
    }

    public User findOne(String userId) {
        List<User> list = findAll();
        for (User user: list) {
            if(user.getUserId().equals(userId))
                return user;
        }

        return null;
    }

    public List<User> findAll() {
        return em
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    public void remove(User user) {
//        em.remove(findOne(user.getUserId()).getId());
    }
}
