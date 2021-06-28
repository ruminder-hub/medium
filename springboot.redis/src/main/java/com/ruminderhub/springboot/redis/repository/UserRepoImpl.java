package com.ruminderhub.springboot.redis.repository;

import com.ruminderhub.springboot.redis.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepoImpl implements UserRepo{

    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;
    private static final String userListName = "USER";

    public UserRepoImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public User find(String username) {
        return (User)hashOperations.get(userListName, username);
    }

    @Override
    public void save(User user) {
        hashOperations.put(userListName, user.getUsername(), user);
    }

    @Override
    public void update(User user) {
        hashOperations.put(userListName, user.getUsername(), user);
    }

    @Override
    public void saveAll(List<User> user) {
        Map<String, User> userMap = user.stream().collect(Collectors.toMap(User::getUsername, u -> u));
        hashOperations.putAll(userListName, userMap);
    }

    @Override
    public void delete(User user) {
        hashOperations.delete(userListName, user.getUsername());
    }

    @Override
    public List<User> findAll() {
        return (List)hashOperations.entries(userListName).values();
    }

    @Override
    public void updateAll(List<User> user) {
        Map<String, User> userMap = user.stream().collect(Collectors.toMap(User::getUsername, u -> u));
        hashOperations.putAll(userListName, userMap);
    }
}
