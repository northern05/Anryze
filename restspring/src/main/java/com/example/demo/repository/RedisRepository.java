package com.example.demo.repository;

import com.example.demo.model.Account;

import java.util.Map;

public interface RedisRepository {
    Map<Object, Object> findAllAccounts();
    void add(Account account);
    void delete(String id);
    Account findAccount(String username);
}
