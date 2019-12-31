package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Account";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Account account) {
        hashOperations.put(KEY, account.getUsername(), account.getPassword());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    public Account findAccount(final String username){
        return (Account) hashOperations.get(KEY, username);
    }

    public Map<Object, Object> findAllAccounts(){
        return hashOperations.entries(KEY);
    }

}
