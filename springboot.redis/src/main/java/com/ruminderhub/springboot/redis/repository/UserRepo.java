package com.ruminderhub.springboot.redis.repository;

import com.ruminderhub.springboot.redis.model.User;

import java.util.List;

public interface UserRepo {

    void save(User user);

    User find(String username);

    void update(User user);

    void delete(User user);

    void saveAll(List<User> user);

    List<User> findAll();

    void updateAll(List<User> user);
}
