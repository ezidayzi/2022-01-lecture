package com.ezidayzi.repository;

import com.ezidayzi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void insert(User user) {
        em.persist(user);
    }

    public User findOne(int id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    public void remove(User user) {
        em.remove(user);
    }
}
