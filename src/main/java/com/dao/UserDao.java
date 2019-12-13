package com.dao;

import com.domain.User;

import java.util.List;

/**
 * @outhor li
 * @create 2019-12-13 1:11
 */
public interface UserDao {
    List<User> findAll();
}
